-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Ven 13 Avril 2018 à 13:01
-- Version du serveur :  5.7.11
-- Version de PHP :  5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `proxibanquebdd`
--
CREATE DATABASE IF NOT EXISTS `proxibanquebdd` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `proxibanquebdd`;

-- --------------------------------------------------------

--
-- Structure de la table `agence`
--

CREATE TABLE `agence` (
  `agence_id` int(11) NOT NULL,
  `agence_numIdentif` varchar(45) DEFAULT NULL,
  `agence_dtCreation` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `agence`
--

INSERT INTO `agence` (`agence_id`, `agence_numIdentif`, `agence_dtCreation`) VALUES
(3, 'GDLKJ', '2018-04-12');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `client_id` int(11) NOT NULL,
  `client_nom` varchar(45) NOT NULL,
  `client_prenom` varchar(45) NOT NULL,
  `client_adresse` varchar(45) NOT NULL,
  `client_cdPostal` int(11) NOT NULL,
  `client_ville` varchar(45) NOT NULL,
  `client_email` varchar(255) NOT NULL,
  `client_conseiller_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`client_id`, `client_nom`, `client_prenom`, `client_adresse`, `client_cdPostal`, `client_ville`, `client_email`, `client_conseiller_id`) VALUES
(5, 'BenWalli', 'Samuelle', '35 avenue lacassagne', 69100, 'villeurbanne', 'monemail@mail.jp', 4),
(6, 'Lopez', 'Jennifer', '13 cours Franklin Roosevelt', 69006, 'Lyon', 'j.lopez@lopez.com', 5),
(7, 'Pitt', 'Brad', '7 cours Lafayette', 69006, 'Lyon', 'b.pitt@hotmail.fr', 5),
(9, 'toto', 'totofamilly', 'lkhljkh', 96333, ':khljh', 'lkhlh', 4),
(10, 'tanaka', 'hoshiro', 'someWhere', 96696, 'Kyoto', 'jesuisauJapon@etTasLesBoules.com', 5),
(12, 'Toyota', 'coco', 'Dans un bunker', 66666, 'Hiroshima', 'GUnTroisiemeBras@joke.com', 6);

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `compte_id` int(11) NOT NULL,
  `compte_numCompte` varchar(45) NOT NULL,
  `compte_solde` int(11) NOT NULL,
  `compte_dt_Creation` datetime NOT NULL,
  `compte_typeCompte_id` int(11) NOT NULL,
  `compte_client_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `compte`
--

INSERT INTO `compte` (`compte_id`, `compte_numCompte`, `compte_solde`, `compte_dt_Creation`, `compte_typeCompte_id`, `compte_client_id`) VALUES
(5, 'C86542', 56413287, '2014-12-16 11:17:31', 5, 5),
(6, 'C96526', 1235053, '2011-02-04 15:27:20', 5, 6),
(7, 'C96321', 200, '2011-11-07 15:39:40', 5, 7),
(9, 'E48932', 14000, '2018-04-17 13:47:23', 6, 6),
(10, 'C00693', 3000, '2018-04-01 00:00:00', 5, 10),
(11, 'E00693', 2000, '2018-04-07 00:00:00', 6, 10),
(14, 'C5498', 652, '2018-04-08 00:00:00', 5, 12),
(15, 'E56843', 30, '2018-03-04 00:00:00', 6, 12),
(16, 'C5498', 652, '2018-04-08 00:00:00', 5, 12),
(17, 'E56843', 30, '2018-03-04 00:00:00', 6, 12);

-- --------------------------------------------------------

--
-- Structure de la table `conseiller`
--

CREATE TABLE `conseiller` (
  `conseiller_id` int(11) NOT NULL,
  `conseiller_nom` varchar(45) NOT NULL,
  `conseiller_prenom` varchar(45) NOT NULL,
  `conseiller_login` varchar(45) NOT NULL,
  `conseiller_password` varchar(255) NOT NULL,
  `conseiller_agence_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `conseiller`
--

INSERT INTO `conseiller` (`conseiller_id`, `conseiller_nom`, `conseiller_prenom`, `conseiller_login`, `conseiller_password`, `conseiller_agence_id`) VALUES
(4, 'Mandela', 'Nelson', 'Mandela', 'Nelson', 3),
(5, 'Balzac', 'Rachid', 'Balzac', 'Rachid', 3),
(6, 'Dessouza', 'Manuel', 'Dessouza', 'Manuel', 3);

-- --------------------------------------------------------

--
-- Structure de la table `typecompte`
--

CREATE TABLE `typecompte` (
  `typeCompte_id` int(11) NOT NULL,
  `typeCompte_libelle` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `typecompte`
--

INSERT INTO `typecompte` (`typeCompte_id`, `typeCompte_libelle`) VALUES
(5, 'Courant'),
(6, 'Epargne');

-- --------------------------------------------------------

--
-- Structure de la table `virement`
--

CREATE TABLE `virement` (
  `virement_id` int(11) NOT NULL,
  `virement_compte_id_emetteur` int(11) NOT NULL,
  `virement_compte_id_cible` int(11) NOT NULL,
  `virement_valeur` int(11) NOT NULL,
  `virement_description` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `agence`
--
ALTER TABLE `agence`
  ADD PRIMARY KEY (`agence_id`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`client_id`),
  ADD KEY `fk_client_conseiller_idx` (`client_conseiller_id`);

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`compte_id`),
  ADD KEY `fk_compte_typeCompte1_idx` (`compte_typeCompte_id`),
  ADD KEY `fk_compte_client1_idx` (`compte_client_id`);

--
-- Index pour la table `conseiller`
--
ALTER TABLE `conseiller`
  ADD PRIMARY KEY (`conseiller_id`),
  ADD KEY `fk_conseiller_agence1_idx` (`conseiller_agence_id`);

--
-- Index pour la table `typecompte`
--
ALTER TABLE `typecompte`
  ADD PRIMARY KEY (`typeCompte_id`);

--
-- Index pour la table `virement`
--
ALTER TABLE `virement`
  ADD PRIMARY KEY (`virement_id`),
  ADD KEY `fk_virement_compte_idx` (`virement_compte_id_emetteur`),
  ADD KEY `fk_virement_compte1_idx` (`virement_compte_id_cible`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `agence`
--
ALTER TABLE `agence`
  MODIFY `agence_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `client_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT pour la table `compte`
--
ALTER TABLE `compte`
  MODIFY `compte_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT pour la table `conseiller`
--
ALTER TABLE `conseiller`
  MODIFY `conseiller_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT pour la table `typecompte`
--
ALTER TABLE `typecompte`
  MODIFY `typeCompte_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT pour la table `virement`
--
ALTER TABLE `virement`
  MODIFY `virement_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `fk_client_conseiller` FOREIGN KEY (`client_conseiller_id`) REFERENCES `conseiller` (`conseiller_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `compte`
--
ALTER TABLE `compte`
  ADD CONSTRAINT `fk_compte_client1` FOREIGN KEY (`compte_client_id`) REFERENCES `client` (`client_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_compte_typeCompte1` FOREIGN KEY (`compte_typeCompte_id`) REFERENCES `typecompte` (`typeCompte_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `conseiller`
--
ALTER TABLE `conseiller`
  ADD CONSTRAINT `fk_conseiller_agence1` FOREIGN KEY (`conseiller_agence_id`) REFERENCES `agence` (`agence_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `virement`
--
ALTER TABLE `virement`
  ADD CONSTRAINT `fk_virement_compte` FOREIGN KEY (`virement_compte_id_emetteur`) REFERENCES `compte` (`compte_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_virement_compte1` FOREIGN KEY (`virement_compte_id_cible`) REFERENCES `compte` (`compte_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
