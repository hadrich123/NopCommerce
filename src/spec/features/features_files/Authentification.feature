@authentification
Feature: Je souhaite tester la page de connexion de l application nopcommerce

  @authentification_valide
  Scenario: Je souhaite tester la page de connexion  avec un cas passant  
  
  Given Je me connecte a l application
  Then Je me redirige vers le dashboard
  
  @authentification_invalide
  Scenario: Je souhaite tester la page de connexion avec un cas non passant 
  Given Je me connecte a l application avec incorrecte cordonne
  Then Un message d erreur est affiche

