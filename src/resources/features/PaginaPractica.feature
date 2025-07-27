Feature: Probar Ingreso de Información

  Background:
    Given el usuario abre el navegador

  @Practica
  Rule: Ingreso de Información Pagina Practice Form

    Example: Campos validos
      Given El usuario esta en la página Practice Form.
      When El usuario ingresa información en los campos requeridos.
      Then La información se guarda correctamente.


