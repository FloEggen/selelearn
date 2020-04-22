# language: fr
Fonctionnalité: Vérification des fonctionnalités de l'application RDU

  @Rdu @Admin
  Scénario: Tester les scénario d'administration
    Etant donné Un utilisateur accède à l'application rdu via le portail iam
    Et l'utilisateur choisit le contexte 'Administrateur'
    Quand l'utilisateur créé un profil avec code: 'PROFIL_TEST_CODE', libellé: 'Libellé Profil Test' et droits: 'ACC_ECH'
    Alors le profil avec le code 'PROFIL_TEST_CODE' existe dans la liste des profils


