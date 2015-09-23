require 'buildr/jaxb_xjc'
raise 'Patch applied in latest release of buildr' if Buildr::VERSION > '1.4.23'

module Buildr
  module JaxbXjc
    def compile_jaxb(files, *args)
      options = Hash === args.last ? args.pop.dup : {}
      rake_check_options options, :directory, :keep_content, :package, :id
      args = args.dup
      files = Array === files ? files.flatten : [files]

      target_dir = File.expand_path(options[:directory] || _(:target, :generated, :jaxb, 'main/java'))
      timestamp_file = File.expand_path("#{target_dir}/jaxb-#{options[:id] || 1}.cache")

      project.iml.main_generated_source_directories << target_dir if project.iml?

      file(target_dir => timestamp_file)

      file(timestamp_file => files.flatten) do |task|
        rm_rf target_dir unless options[:keep_content]
        mkdir_p target_dir
        args << '-d' << target_dir
        args << '-p' << options[:package] if options[:package]
        args += files.collect{|f| f.to_s}
        JaxbXjc.xjc args
        touch timestamp_file
      end

      target_dir
    end
  end
end
