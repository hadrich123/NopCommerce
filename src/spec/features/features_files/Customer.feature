@Customer
Feature: Je souhaite tester le module cutomer

  Background:
   Given Je me connecte a l application
   And Je m accede a l espace customer
  @addCustomer
  Scenario: Je shouhaite ajouter un customer
 
   When Je clique sur le bouton Add new 
   And Je saisie l email et password  
   And Je select le role
   And Je clique sur le bouton save
   Then Un message d ajout s affiche 
 
 @searchExistedCustomer
 Scenario: Je souhaite faire la recherche d un customer existant
 
     When Je saisie l email de customer 
     And Je clique sur le bouton search 
     Then Le cusmtomer s affiche dans le tableau
     
     @searchNotexistedCustomer
  Scenario: Je souhaite verifier si customer n existe pas 
  
     When Je saisie l email de customer inexistant  
     And Je clique sur le bouton search 
     Then Le tableau s affiche vide 
     
     @EditCustomer
     
      Scenario: Je souhaite modifier les information d un customer
      
     When Je saisie l email de customer 
     And Je clique sur le bouton search 
     And Je clique sur le bouton edit 
     And Je modifie les information souhaite
     And Je clique sur le bouton save
     And Un messge d update s affiche 
     
     
  @deleteCustomer
  Scenario: Je souhaite supprimer un customer
  
     When Je saisie l email de customer 
     And Je clique sur le bouton search 
     And Je clique sur le bouton edit 
     And Je clique sur le bouton delete
     And Je clique sur delete d alert 
     And Un messge de delete s affiche 
