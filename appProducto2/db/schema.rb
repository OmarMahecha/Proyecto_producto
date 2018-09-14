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

ActiveRecord::Schema.define(version: 2018_09_13_135006) do

  # These are extensions that must be enabled in order to support this database
  enable_extension "plpgsql"

  create_table "active_admin_comments", force: :cascade do |t|
    t.string "namespace"
    t.text "body"
    t.string "resource_type"
    t.bigint "resource_id"
    t.string "author_type"
    t.bigint "author_id"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.index ["author_type", "author_id"], name: "index_active_admin_comments_on_author_type_and_author_id"
    t.index ["namespace"], name: "index_active_admin_comments_on_namespace"
    t.index ["resource_type", "resource_id"], name: "index_active_admin_comments_on_resource_type_and_resource_id"
  end

  create_table "adjuntos", force: :cascade do |t|
    t.datetime "fecha_adjunto"
    t.text "ruta_adjunto"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.bigint "solicitud_id"
    t.bigint "tipo_adjunto_id"
    t.bigint "user_id"
    t.index ["solicitud_id"], name: "index_adjuntos_on_solicitud_id"
    t.index ["tipo_adjunto_id"], name: "index_adjuntos_on_tipo_adjunto_id"
    t.index ["user_id"], name: "index_adjuntos_on_user_id"
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
    t.bigint "user_id"
    t.bigint "estado_id"
    t.bigint "solicitud_id"
    t.index ["estado_id"], name: "index_historicos_on_estado_id"
    t.index ["solicitud_id"], name: "index_historicos_on_solicitud_id"
    t.index ["user_id"], name: "index_historicos_on_user_id"
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
    t.bigint "user_id"
    t.bigint "estado_id"
    t.string "usuario_autoriza_prioridad"
    t.text "observacion_prioridad"
    t.datetime "tiempo_atipico"
    t.text "observacion_atipico"
    t.index ["estado_id"], name: "index_solicitudes_on_estado_id"
    t.index ["user_id"], name: "index_solicitudes_on_user_id"
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

  create_table "users", force: :cascade do |t|
    t.string "email", default: "", null: false
    t.string "encrypted_password", default: "", null: false
    t.string "reset_password_token"
    t.datetime "reset_password_sent_at"
    t.datetime "remember_created_at"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.string "name"
    t.index ["email"], name: "index_users_on_email", unique: true
    t.index ["reset_password_token"], name: "index_users_on_reset_password_token", unique: true
  end

  add_foreign_key "adjuntos", "solicitudes", column: "solicitud_id"
  add_foreign_key "adjuntos", "tipos_adjuntos", column: "tipo_adjunto_id"
  add_foreign_key "adjuntos", "users"
  add_foreign_key "historicos", "estados"
  add_foreign_key "historicos", "solicitudes", column: "solicitud_id"
  add_foreign_key "historicos", "users"
  add_foreign_key "solicitudes", "estados"
  add_foreign_key "solicitudes", "users"
end
