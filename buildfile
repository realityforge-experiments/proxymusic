require 'buildr/git_auto_version'
require 'buildr/jaxb_xjc'
require 'buildr/top_level_generate_dir'

PROVIDED_DEPS = [:javax_annotation]

desc 'ProxyMusic provides a binding between Java objects in memory and data formatted according to MusicXML 3.0'
define 'proxymusic' do
  project.group = 'com.audiveris'
  compile.options.source = '1.7'
  compile.options.target = '1.7'
  compile.options.lint = 'all'

  project.version = ENV['PRODUCT_VERSION'] if ENV['PRODUCT_VERSION']

  compile.with PROVIDED_DEPS, :slf4j_api

  compile.from compile_jaxb(_('src/main/xsd/musicxml.xsd'),
                            '-quiet',
                            '-b',
                            _('src/main/xjb/musicxml.xjb'),
                            :package => 'com.audiveris.proxymusic',
                            :directory => _(:target, :generated, :musicxml, 'main/java'))
  compile.from compile_jaxb(_('src/main/xsd/opus.xsd'),
                            '-quiet',
                            :package => 'com.audiveris.proxymusic.opus',
                            :directory => _(:target, :generated, :opus, 'main/java'))

  test.with :slf4j_jdk14

  package(:jar)
  package(:sources)
  package(:javadoc)

  iml.add_jruby_facet
end
