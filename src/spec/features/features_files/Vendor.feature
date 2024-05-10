@Vendor
Feature: Je souhaite tester le module vendors

  Background:
   Given Je me connecte a l application
   And Je m accede a l espace vendors
   When Je saisie le nom de vendor
     And Je clique sur le bouton search vendor
   
  @searchVendor
  Scenario: Je souhaite faire la recherche d un vendor existant
  
     Then Le vendor s affiche dans le tableau
     
   @editVendror
  Scenario: Je souhaite modifier les information d un vendor
      
     And Je clique sur le bouton edit vendor
     And Je modifie les information de vendor 
     And Je clique sur le bouton save des modifications 
     And Un messge d update de vendor s affiche 
 
