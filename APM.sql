-- phpMyAdmin SQL Dump
-- version 4.4.15.7
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1:3306
-- Время создания: Янв 24 2020 г., 03:27
-- Версия сервера: 5.5.50
-- Версия PHP: 5.3.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `APM`
--

-- --------------------------------------------------------

--
-- Структура таблицы `Department`
--

CREATE TABLE IF NOT EXISTS `Department` (
  `id` int(11) NOT NULL,
  `depName` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `Department`
--

INSERT INTO `Department` (`id`, `depName`) VALUES
(1, 'Цех 1'),
(2, 'Цех 2');

-- --------------------------------------------------------

--
-- Структура таблицы `Detail`
--

CREATE TABLE IF NOT EXISTS `Detail` (
  `id` int(11) NOT NULL,
  `detailName` varchar(50) NOT NULL,
  `yearWarranty` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `Detail`
--

INSERT INTO `Detail` (`id`, `detailName`, `yearWarranty`) VALUES
(1, 'ТШ 6', 1),
(2, 'DYA-3B', 2);

-- --------------------------------------------------------

--
-- Структура таблицы `Object`
--

CREATE TABLE IF NOT EXISTS `Object` (
  `id` int(11) NOT NULL,
  `objectName` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `Object`
--

INSERT INTO `Object` (`id`, `objectName`) VALUES
(1, 'ДТ');

-- --------------------------------------------------------

--
-- Структура таблицы `Registration`
--

CREATE TABLE IF NOT EXISTS `Registration` (
  `department` varchar(50) NOT NULL,
  `station` varchar(50) NOT NULL,
  `object` varchar(50) NOT NULL,
  `leftDays` int(11) NOT NULL,
  `detail` varchar(50) NOT NULL,
  `lastCheck` date NOT NULL,
  `nextCheck` date NOT NULL,
  `location` int(11) NOT NULL,
  `registrationID` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=175 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `Registration`
--

INSERT INTO `Registration` (`department`, `station`, `object`, `leftDays`, `detail`, `lastCheck`, `nextCheck`, `location`, `registrationID`) VALUES
('Цех 1', 'Северный вокзал', 'ДТ', 15, 'ТШ 6', '2018-02-13', '2019-02-13', 4, 10),
('Цех 1', 'Рахимова', 'ДТ', 9, 'ТШ 6', '2018-02-19', '2019-02-19', 2, 118),
('Цех 1', 'Рахимова', 'ДТ', -676, 'ТШ 6', '2020-01-04', '2021-01-04', 2, 119),
('Цех 1', 'Рахимова', 'ДТ', -1041, 'ТШ 6', '2021-01-04', '2022-01-04', 2, 120),
('Цех 1', 'Рахимова', 'ДТ', -1406, 'ТШ 6', '2022-01-04', '2023-01-04', 2, 121),
('Цех 1', 'Рахимова', 'ДТ', -1771, 'ТШ 6', '2023-01-04', '2024-01-04', 2, 122),
('Цех 1', 'Рахимова', 'ДТ', -2137, 'ТШ 6', '2024-01-04', '2025-01-04', 2, 123),
('Цех 1', 'Рахимова', 'ДТ', -2502, 'ТШ 6', '2025-01-04', '2026-01-04', 2, 124),
('Цех 1', 'Рахимова', 'ДТ', -2867, 'ТШ 6', '2026-01-04', '2027-01-04', 2, 125),
('Цех 1', 'Рахимова', 'ДТ', -4693, 'ТШ 6', '2031-01-04', '2032-01-04', 2, 130),
('Цех 1', 'Рахимова', 'ДТ', -5059, 'ТШ 6', '2032-01-04', '2033-01-04', 2, 131),
('Цех 1', 'Рахимова', 'ДТ', -7250, 'ТШ 6', '2038-01-04', '2039-01-04', 2, 137),
('Цех 1', 'Рахимова', 'ДТ', -9807, 'ТШ 6', '2045-01-04', '2046-01-04', 2, 144),
('Цех 1', 'Рахимова', 'ДТ', -10172, 'ТШ 6', '2046-01-04', '2047-01-04', 2, 145),
('Цех 1', 'Рахимова', 'ДТ', -10903, 'ТШ 6', '2048-01-04', '2049-01-04', 2, 147),
('Цех 1', 'Рахимова', 'ДТ', -11268, 'ТШ 6', '2049-01-04', '2050-01-04', 2, 148),
('Цех 1', 'Рахимова', 'ДТ', -11633, 'ТШ 6', '2050-01-04', '2051-01-04', 2, 149),
('Цех 1', 'Рахимова', 'ДТ', -11998, 'ТШ 6', '2051-01-04', '2052-01-04', 2, 150),
('Цех 1', 'Рахимова', 'ДТ', -12364, 'ТШ 6', '2052-01-04', '2053-01-04', 2, 151),
('Цех 1', 'Рахимова', 'ДТ', -12729, 'ТШ 6', '2053-01-04', '2054-01-04', 2, 152),
('Цех 1', 'Рахимова', 'ДТ', -13094, 'ТШ 6', '2054-01-04', '2055-01-04', 2, 153),
('Цех 1', 'Рахимова', 'ДТ', -13459, 'ТШ 6', '2055-01-04', '2056-01-04', 2, 154),
('Цех 1', 'Рахимова', 'ДТ', -13825, 'ТШ 6', '2056-01-04', '2057-01-04', 2, 155),
('Цех 1', 'Рахимова', 'ДТ', -14190, 'ТШ 6', '2057-01-04', '2058-01-04', 2, 156),
('Цех 1', 'Рахимова', 'ДТ', -14555, 'ТШ 6', '2058-01-04', '2059-01-04', 2, 157),
('Цех 1', 'Рахимова', 'ДТ', -14920, 'ТШ 6', '2059-01-04', '2060-01-04', 2, 158),
('Цех 1', 'Рахимова', 'ДТ', -15286, 'ТШ 6', '2060-01-04', '2061-01-04', 2, 159),
('Цех 1', 'Рахимова', 'ДТ', -15651, 'ТШ 6', '2061-01-04', '2062-01-04', 2, 160),
('Цех 1', 'Рахимова', 'ДТ', -16016, 'ТШ 6', '2062-01-04', '2063-01-04', 2, 161),
('Цех 1', 'Рахимова', 'ДТ', -16381, 'ТШ 6', '2063-01-04', '2064-01-04', 2, 162),
('Цех 1', 'Рахимова', 'ДТ', -16747, 'ТШ 6', '2064-01-04', '2065-01-04', 2, 163),
('Цех 1', 'Рахимова', 'ДТ', -17112, 'ТШ 6', '2065-01-04', '2066-01-04', 2, 164),
('Цех 1', 'Рахимова', 'ДТ', -17477, 'ТШ 6', '2066-01-04', '2067-01-04', 2, 165),
('Цех 1', 'Рахимова', 'ДТ', -17842, 'ТШ 6', '2067-01-04', '2068-01-04', 2, 166),
('Цех 1', 'Рахимова', 'ДТ', -18208, 'ТШ 6', '2068-01-04', '2069-01-04', 2, 167),
('Цех 1', 'Рахимова', 'ДТ', -18573, 'ТШ 6', '2069-01-04', '2070-01-04', 2, 168),
('Цех 1', 'Рахимова', 'ДТ', -18938, 'ТШ 6', '2070-01-04', '2071-01-04', 2, 169),
('Цех 1', 'Рахимова', 'ДТ', -19303, 'ТШ 6', '2071-01-04', '2072-01-04', 2, 170),
('Цех 1', 'Рахимова', 'ДТ', -19669, 'ТШ 6', '2072-01-04', '2073-01-04', 2, 171),
('Цех 1', 'Рахимова', 'ДТ', -20034, 'ТШ 6', '2073-01-04', '2074-01-04', 2, 172),
('Цех 1', 'Северный вокзал', 'ДТ', -715, 'DYA-3B', '2019-02-12', '2021-02-12', 5, 173),
('Цех 1', 'Северный вокзал', 'ДТ', -1445, 'DYA-3B', '2021-02-12', '2023-02-12', 5, 174);

-- --------------------------------------------------------

--
-- Структура таблицы `Station`
--

CREATE TABLE IF NOT EXISTS `Station` (
  `id` int(11) NOT NULL,
  `stationName` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `Station`
--

INSERT INTO `Station` (`id`, `stationName`) VALUES
(1, 'Рахимова'),
(2, 'Северный вокзал');

-- --------------------------------------------------------

--
-- Структура таблицы `Users`
--

CREATE TABLE IF NOT EXISTS `Users` (
  `id` int(3) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `Users`
--

INSERT INTO `Users` (`id`, `name`, `password`) VALUES
(1, 'Jimy', '12345');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `Department`
--
ALTER TABLE `Department`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `Detail`
--
ALTER TABLE `Detail`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `Object`
--
ALTER TABLE `Object`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `Registration`
--
ALTER TABLE `Registration`
  ADD PRIMARY KEY (`registrationID`),
  ADD KEY `department` (`department`),
  ADD KEY `station` (`station`),
  ADD KEY `object` (`object`),
  ADD KEY `detail` (`detail`);

--
-- Индексы таблицы `Station`
--
ALTER TABLE `Station`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `Users`
--
ALTER TABLE `Users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `Department`
--
ALTER TABLE `Department`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT для таблицы `Detail`
--
ALTER TABLE `Detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT для таблицы `Object`
--
ALTER TABLE `Object`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT для таблицы `Registration`
--
ALTER TABLE `Registration`
  MODIFY `registrationID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=175;
--
-- AUTO_INCREMENT для таблицы `Station`
--
ALTER TABLE `Station`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT для таблицы `Users`
--
ALTER TABLE `Users`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
