# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 2018_09_06_141828) do

  # These are extensions that must be enabled in order to support this database
  enable_extension "plpgsql"

  create_table "adjuntos", force: :cascade do |t|
    t.datetime "fecha_adjunto"
    t.text "ruta_adjunto"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "alertas", force: :cascade do |t|
    t.text "mensaje_alerta"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "estados", force: :cascade do |t|
    t.string "estado"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "historicos", force: :cascade do |t|
    t.datetime "fecha_cambio"
    t.text "observacion_historico"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "perfiles", force: :cascade do |t|
    t.string "perfil"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "prioridades_solicitud", force: :cascade do |t|
    t.text "observacion_prioridad"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "productos_atipicos", force: :cascade do |t|
    t.datetime "tiempo_producto_atipico"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "solicitudes", force: :cascade do |t|
    t.datetime "fecha_creacion"
    t.datetime "tiempo_oferta_comercial"
    t.boolean "es_prioridad"
    t.boolean "es_atipico"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "tiempos", force: :cascade do |t|
    t.datetime "tiempo"
    t.string "detalle"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "tipos_adjuntos", force: :cascade do |t|
    t.string "tipo_adjunto"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "usuarios", force: :cascade do |t|
    t.string "email", default: "", null: false
    t.string "encrypted_password", default: "", null: false
    t.string "reset_password_token"
    t.datetime "reset_password_sent_at"
    t.datetime "remember_created_at"
    t.string "nombre"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.index ["email"], name: "index_usuarios_on_email", unique: true
    t.index ["reset_password_token"], name: "index_usuarios_on_reset_password_token", unique: true
  end

end
