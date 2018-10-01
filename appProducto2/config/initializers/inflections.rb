# Be sure to restart your server when you modify this file.

# Add new inflection rules using the following format. Inflections
# are locale specific, and you may define rules for as many different
# locales as you wish. All of these examples are active by default:
# ActiveSupport::Inflector.inflections(:en) do |inflect|
#   inflect.plural /^(ox)$/i, '\1en'
#   inflect.singular /^(ox)en/i, '\1'
#   inflect.irregular 'person', 'people'
#   inflect.uncountable %w( fish sheep )
# end

# These inflection rules are supported but not enabled by default:
# ActiveSupport::Inflector.inflections(:en) do |inflect|
#   inflect.acronym 'RESTful'
# end
ActiveSupport::Inflector.inflections do |inflect| 
    inflect.plural 'solicitud', 'solicitudes'
    inflect.plural 'tiempo', 'tiempos'
    inflect.plural 'adjunto', 'adjuntos'
    inflect.plural 'prioridad', 'prioridades'
    inflect.plural 'producto_atipico', 'productos_atipicos'
    inflect.plural 'tipo_adjunto', 'tipos_adjuntos'
    inflect.plural 'usuario', 'usuarios'
    inflect.plural 'perfil', 'perfiles'
    inflect.plural 'estado', 'estados'
    inflect.plural 'historico', 'historicos'
    inflect.plural 'alerta', 'alertas'
end 