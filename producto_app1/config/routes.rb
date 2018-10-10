Rails.application.routes.draw do
  devise_for :usuarios
  as :user do
  get '/usuario/sign_out' => 'devise/sessions#destroy'
end
  root 'home#index'
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
end
