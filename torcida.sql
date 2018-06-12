-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 12-Jun-2018 às 17:39
-- Versão do servidor: 5.7.19-0ubuntu0.16.04.1
-- PHP Version: 7.0.22-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `torcida`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `clubes`
--

CREATE TABLE `clubes` (
  `id` int(11) NOT NULL,
  `nome` varchar(40) NOT NULL,
  `cidade` varchar(20) DEFAULT NULL,
  `uf` enum('AC','AL','AP','AM','BA','CE','DF','ES','GO','MA','MT','MS','MG','PA','PB','PR','PE','PI','RJ','RN','RS','RO','RR','SC','SP','SE','TO') DEFAULT NULL,
  `fundacao` date DEFAULT NULL,
  `mascote` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `clubes`
--

INSERT INTO `clubes` (`id`, `nome`, `cidade`, `uf`, `fundacao`, `mascote`) VALUES
(1, 'América Futebol Clube', 'Belo Horizonte', 'MG', '1912-05-30', 'Coelho'),
(2, 'Clube Atlético Mineiro', 'Belo Horizonte', 'MG', '1908-03-25', 'Galo'),
(3, 'Clube Atlético Paranaense', 'Curitiba', 'PR', '1924-03-26', 'Cartola'),
(4, 'Esporte Clube Bahia', 'Salvador', 'BA', '1931-01-01', 'Super-Homem'),
(5, 'Botafogo de Futebol e Regatas', 'Rio de Janeiro', 'RJ', '1902-08-12', 'Manequinho'),
(6, 'Ceará Sporting Club', 'Fortaliza', 'CE', '1914-06-02', 'Vovô'),
(7, 'Associação Chapecoense de Futebol', 'Chapecó', 'SC', '1973-05-10', 'Índio Condá'),
(8, 'Sport Club Corinthians Paulista', 'São Paulo', 'SP', '1910-09-01', 'Mosqueteiro'),
(9, 'Cruzeiro Esporte Clube', 'Belo Horizonte', 'MG', '1921-01-02', 'Raposa'),
(10, 'Clube de Regatas do Flamengo', 'Rio de Janeiro', 'RJ', '1895-11-15', 'Urubu'),
(11, 'Fluminense Football Club', 'Rio de Janeiro', 'RJ', '1902-07-21', 'Cartola'),
(12, 'Grêmio Foot-Ball Porto Alegrense', 'Porto Alegre', 'RS', '1902-09-15', 'Mosqueteiro'),
(13, 'Sport Club Internacional', 'Porto Alegre', 'RS', '1909-04-04', 'Saci'),
(14, 'Sociedade Esportiva Palmeiras', 'São Paulo', 'SP', '1914-08-26', 'Porco'),
(15, 'Paraná Clube', 'Curitiba', 'PR', '1989-12-19', 'Gralha Azul'),
(16, 'Santos Futebol Clube', 'Santos', 'SP', '1912-04-14', 'Baleia'),
(17, 'São Paulo Futebol Clube', 'São Paulo', 'SP', '1930-01-15', 'São Paulo (Santo)'),
(18, 'Sport Club do Recife', 'Recife', 'PE', '1905-05-13', 'Leão'),
(19, 'Club de Regatas Vasco da Gama', 'Rio de Janeiro', 'RJ', '1898-08-21', 'Almirante'),
(20, 'Esporte Clube Vitória', 'Salvador', 'BA', '1899-05-13', 'Leão');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoas`
--

CREATE TABLE `pessoas` (
  `id` int(11) NOT NULL,
  `nome` varchar(40) NOT NULL,
  `profissao` varchar(20) DEFAULT NULL,
  `nascimento` date DEFAULT NULL,
  `sexo` enum('M','F') DEFAULT NULL,
  `peso` decimal(5,2) DEFAULT NULL,
  `altura` decimal(3,2) DEFAULT NULL,
  `nacionalidade` varchar(20) DEFAULT 'Brasil',
  `time_preferido` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `pessoas`
--

INSERT INTO `pessoas` (`id`, `nome`, `profissao`, `nascimento`, `sexo`, `peso`, `altura`, `nacionalidade`, `time_preferido`) VALUES
(1, 'Daniel Morais', 'Auxiliar Administrat', '1984-01-02', 'M', '78.50', '1.83', 'Brasil', 7),
(2, 'Talita Nascimento', 'Farmacêutico', '1999-12-30', 'F', '55.20', '1.65', 'Portugal', 16),
(3, 'Emerson Gabriel', 'Programador', '1920-12-30', 'M', '50.20', '1.65', 'Moçambique', 7),
(4, 'Lucas Damasceno', 'Auxiliar Administrat', '1930-11-02', 'M', '63.20', '1.75', 'Irlanda', 12),
(5, 'Leila Martins', 'Farmacêutico', '1975-04-22', 'F', '99.00', '2.15', 'Brasil', 7),
(6, 'Letícia Neves', 'Programador', '1999-12-03', 'F', '87.00', '2.00', 'Brasil', 13),
(7, 'Janaína Couto', 'Auxiliar Administrat', '1987-11-12', 'F', '75.40', '1.66', 'EUA', 9),
(8, 'Carlisson Rosa', 'Professor', '2010-08-01', 'M', '78.22', '1.98', 'Brasil', 14),
(9, 'Jackson Telles', 'Programador', '1999-01-23', 'M', '55.75', '1.33', 'Portugal', 5),
(10, 'Danilo Araujo', 'Dentista', '1975-12-10', 'M', '99.21', '1.87', 'EUA', 5),
(11, 'Andreia Delfino', 'Auxiliar Administrat', '1975-07-01', 'F', '48.64', '1.54', 'Irlanda', 14),
(12, 'Valter Vilmerson', 'Ator', '1985-10-12', 'M', '88.55', '2.03', 'Brasil', 14),
(13, 'Allan Silva', 'Programador', '1993-11-11', 'M', '76.99', '1.55', 'Brasil', 11),
(14, 'Rosana Kunz', 'Professor', '1935-01-16', 'F', '55.24', '1.87', 'Brasil', 20),
(15, 'Josiane Dutra', 'Empreendedor', '1950-01-20', 'F', '98.70', '1.04', 'Portugal', 17),
(16, 'Elvis Schwarz', 'Dentista', '2011-05-07', 'M', '66.69', '1.76', 'EUA', 10),
(17, 'Paulo Narley', 'Auxiliar Administrat', '1997-03-17', 'M', '120.10', '2.22', 'Brasil', 14),
(18, 'Joade Assis', 'Médico', '1930-12-01', 'M', '65.88', '1.78', 'França', 1),
(19, 'Nara Matos', 'Programador', '1978-03-17', 'F', '65.90', '1.33', 'Brasil', 18),
(20, 'Marcos Dissotti', 'Empreendedor', '2010-01-01', 'M', '53.79', '1.54', 'Portugal', NULL),
(21, 'Ana Carolina Mendes', 'Ator', '2000-12-15', 'F', '88.30', '1.54', 'Brasil', 16),
(22, 'Guilherme de Sousa', 'Dentista', '2001-05-18', 'M', '132.70', '1.97', 'Moçambique', 15),
(23, 'Bruno Torres', 'Auxiliar Administrat', '2000-01-30', 'M', '44.65', '1.65', 'Brasil', 14),
(24, 'Yuji Homa', 'Empreendedor', '1996-12-25', 'M', '33.90', '1.22', 'Japão', 16),
(25, 'Raian Porto', 'Programador', '1989-05-05', 'M', '54.89', '1.54', 'Brasil', 20),
(26, 'Paulo Batista', 'Ator', '1999-03-15', 'M', '110.12', '1.87', 'Portugal', 14),
(27, 'Monique Precivalli', 'Auxiliar Administrat', '2013-12-30', 'F', '48.20', '1.22', 'Brasil', 18),
(28, 'Herisson Silva', 'Auxiliar Administrat', '1965-10-10', 'M', '74.65', '1.56', 'EUA', 20),
(29, 'Tiago Ulisses', 'Dentista', '1993-04-22', 'M', '150.30', '2.35', 'Brasil', 18),
(30, 'Anderson Rafael', 'Programador', '1989-12-01', 'M', '64.22', '1.44', 'Irlanda', 8),
(31, 'Karine Ribeiro', 'Empreendedor', '1988-10-01', 'F', '42.10', '1.65', 'Brasil', 19),
(32, 'Roberto Luiz Debarba', 'Ator', '2007-01-09', 'M', '77.44', '1.56', 'Brasil', 5),
(33, 'Jarismar Andrade', 'Dentista', '2000-06-23', 'F', '63.70', '1.33', 'Brasil', 6),
(34, 'Janaina Oliveira', 'Professor', '1955-03-12', 'F', '52.90', '1.76', 'Canadá', 14),
(35, 'Márcio Mello', 'Programador', '2011-11-20', 'M', '54.11', '1.55', 'EUA', 11),
(36, 'Robson Rodolpho', 'Auxiliar Administrat', '2000-08-08', 'M', '110.10', '1.76', 'Brasil', 14),
(37, 'Daniele Moledo', 'Empreendedor', '2006-08-11', 'F', '101.30', '1.99', 'Brasil', 12),
(38, 'Neto Sophiate', 'Ator', '1996-05-17', 'M', '59.28', '1.65', 'Portugal', 10),
(39, 'Neriton Dias', 'Auxiliar Administrat', '2009-10-30', 'M', '48.99', '1.29', 'Brasil', 3),
(40, 'André Schmidt', 'Programador', '1993-07-26', 'M', '55.37', '1.22', 'Angola', 19),
(41, 'Isaias Buscarino', 'Dentista', '2001-01-07', 'M', '99.90', '1.55', 'Moçambique', 13),
(42, 'Rafael Guimma', 'Empreendedor', '1968-04-11', 'M', '88.88', '1.54', 'Brasil', 10),
(43, 'Ana Carolina Hernandes', 'Ator', '1970-10-11', 'F', '65.40', '2.08', 'EUA', 6),
(44, 'Luiz Paulo', 'Professor', '1984-11-01', 'M', '75.12', '1.38', 'Portugal', 9),
(45, 'Bruna Teles', 'Programador', '1980-11-07', 'F', '55.10', '1.86', 'Brasil', 18),
(46, 'Diogo Padilha', 'Auxiliar Administrat', '2000-03-03', 'M', '54.34', '1.88', 'Angola', 9),
(47, 'Bruno Miltersteiner', 'Dentista', '1986-02-19', 'M', '77.45', '1.65', 'Alemanha', 18),
(48, 'Elaine Nunes', 'Programador', '1998-08-15', 'F', '35.90', '2.00', 'Canadá', 19),
(49, 'Silvio Ricardo', 'Programador', '2012-03-12', 'M', '65.99', '1.23', 'EUA', 1),
(50, 'Denilson Barbosa da Silva', 'Empreendedor', '2000-01-08', 'M', '97.30', '2.00', 'Brasil', 6),
(51, 'Jucinei Teixeira', 'Professor', '1977-11-22', 'F', '44.80', '1.76', 'Portugal', 15),
(52, 'Bruna Santos', 'Auxiliar Administrat', '1991-12-01', 'F', '76.30', '1.45', 'Canadá', 19),
(53, 'André Vitebo', 'Médico', '1970-07-01', 'M', '44.11', '1.55', 'Brasil', 12),
(54, 'Andre Santini', 'Programador', '1991-08-15', 'M', '66.00', '1.76', 'Itália', 11),
(55, 'Ruan Valente', 'Programador', '1998-03-19', 'M', '101.90', '1.76', 'Canadá', 15),
(56, 'Nailton Mauricio', 'Médico', '1992-04-25', 'M', '86.01', '1.43', 'EUA', 2),
(57, 'Rita Pontes', 'Professor', '1999-09-02', 'F', '54.10', '1.35', 'Angola', 5),
(58, 'Carlos Camargo', 'Programador', '2005-02-22', 'M', '124.65', '1.33', 'Brasil', 10),
(59, 'Philppe Oliveira', 'Auxiliar Administrat', '2000-05-23', 'M', '105.10', '2.19', 'Brasil', 8),
(60, 'Dayana Dias', 'Professor', '1993-05-30', 'F', '88.30', '1.66', 'Angola', 17),
(61, 'Silvana Albuquerque', 'Programador', '1999-05-22', 'F', '56.00', '1.50', 'Brasil', 19);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clubes`
--
ALTER TABLE `clubes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pessoas`
--
ALTER TABLE `pessoas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `time_preferido` (`time_preferido`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `clubes`
--
ALTER TABLE `clubes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `pessoas`
--
ALTER TABLE `pessoas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=62;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `pessoas`
--
ALTER TABLE `pessoas`
  ADD CONSTRAINT `pessoas_ibfk_1` FOREIGN KEY (`time_preferido`) REFERENCES `clubes` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
