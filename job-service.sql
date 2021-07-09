-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Июл 02 2021 г., 21:47
-- Версия сервера: 10.4.19-MariaDB
-- Версия PHP: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `job-service`
--

-- --------------------------------------------------------

--
-- Структура таблицы `first_category`
--

CREATE TABLE `first_category` (
  `id` bigint(20) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `first_category`
--

INSERT INTO `first_category` (`id`, `first_name`) VALUES
(1, 'Ремонт и строительство'),
(2, 'Ремонт и установка техники'),
(3, 'Ремонт авто'),
(4, 'Репетиторы и обучение'),
(5, 'Красота'),
(6, 'Перевозки и курьеры'),
(7, 'Хозяйство и уборка'),
(8, 'Компьютеры и IT'),
(9, 'Дизайнеры'),
(10, 'Аренда'),
(11, 'Юристы'),
(12, 'Тренеры'),
(13, 'Фото, видео, аудио'),
(14, 'Творчество, рукоделие и хобби'),
(15, 'Организация мероприятий'),
(16, 'Артисты'),
(17, 'Охрана и детективы'),
(18, 'Услуги для животных'),
(19, 'Разное');

-- --------------------------------------------------------

--
-- Структура таблицы `job`
--

CREATE TABLE `job` (
  `id` bigint(20) NOT NULL,
  `date_time` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `first_category_id` bigint(20) DEFAULT NULL,
  `second_category_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `messages`
--

CREATE TABLE `messages` (
  `id` bigint(20) NOT NULL,
  `date_time` datetime DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `receiver_user_id` bigint(20) DEFAULT NULL,
  `sender_user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `proposals`
--

CREATE TABLE `proposals` (
  `id` bigint(20) NOT NULL,
  `send_date_time` datetime DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `job_id` bigint(20) DEFAULT NULL,
  `sender_user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `roles`
--

CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'ROLE_CLIENT'),
(2, 'ROLE_ADMIN'),
(3, 'ROLE_MODERATOR'),
(4, 'ROLE_EXECUTOR');

-- --------------------------------------------------------

--
-- Структура таблицы `second_category`
--

CREATE TABLE `second_category` (
  `id` bigint(20) NOT NULL,
  `second_name` varchar(255) DEFAULT NULL,
  `first_category_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `second_category`
--

INSERT INTO `second_category` (`id`, `second_name`, `first_category_id`) VALUES
(1, 'Ремонт квартир и домов', 1),
(2, 'Проектирование и сметы', 1),
(3, 'Кровельные работы', 1),
(4, 'Полы и напольные покрытия', 1),
(5, 'Сантехнические работы и отопление', 1),
(6, 'Снос и демонтаж', 1),
(7, 'Фасадные работы', 1),
(8, 'Изготовление мебели', 1),
(9, 'Охранные системы и контроль доступа', 1),
(10, 'Плиточные работы', 1),
(11, 'Водоснабжение и канализация', 1),
(12, 'Потолки', 1),
(13, 'Строительство домов и коттеджей', 1),
(14, 'Окна и балконы', 1),
(15, 'Проектирование зданий', 1),
(16, 'Ремонт офиса', 1),
(17, 'Электромонтажные работы', 1),
(18, 'Промышленные полы', 1),
(19, 'Изготовление шкафов-купе', 1),
(20, 'Стекольные услуги', 1),
(21, 'Кладочные работы', 1),
(22, 'Обои и малярные работы', 1),
(23, 'Установка генераторов', 1),
(24, 'Сборка и ремонт мебели', 1),
(25, 'Изготовление кухни', 1),
(26, 'Строительство гаражей', 1),
(27, 'Электродуговая сварка', 1),
(28, 'Умный дом', 1),
(29, 'Изоляция', 1),
(30, 'Дорожное строительство', 1),
(31, 'Лестницы', 1),
(32, 'Строительство бань, саун и бассейнов', 1),
(33, 'Кладка печей и каминов', 1),
(34, 'Вентиляция', 1),
(35, 'Системы пожаротушения', 1),
(36, 'Бетонные работы', 1),
(37, 'Гидроиспытания трубопроводов', 1),
(38, 'Высотные работы', 1),
(39, 'Земляные работы', 1),
(40, 'Заборы и ограждения', 1),
(41, 'Проектирование газовых сетей', 1),
(42, 'Кадастровые работы', 1),
(43, 'Сварочные работы', 1),
(44, 'Рольставни и секционные ворота', 1),
(45, 'Фундамент', 1),
(46, 'Озеленение', 1),
(47, 'Бурение', 1),
(48, 'Демонтаж металлоконструкций', 1),
(49, 'Вскрытие замков', 1),
(50, 'Газовая сварка', 1),
(51, 'Перетяжка и ремонт мягкой мебели', 1),
(52, 'Изготовление металлических дверей', 1),
(53, 'Изготовление ключей', 1),
(54, 'Ремонт и установка замков', 1),
(55, 'Ремонт электрокотлов', 1),
(56, 'Изготовление металлоконструкций', 1),
(57, 'Изыскательные работы', 1),
(58, 'Альтернативная энергия', 1),
(59, 'Изготовление дверей из дерева', 1),
(60, 'Реставрация и эмалировка ванн', 1),
(61, 'Изготовление витражей', 1),
(62, 'Мастер на час', 1),
(63, 'Проектирование металлоконструкций', 1),
(64, 'Слаботочные системы', 1),
(65, 'Ремонт дверей', 1),
(66, 'Установка дверей', 1),
(67, 'Отделка деревянных домов, бань, саун', 1),
(68, 'Ремонт и установка кодовых замков', 1),
(69, 'Теплосчетчики', 1),
(70, 'Изготовление окон', 1),
(71, 'Поверка счетчиков', 1),
(72, 'Изготовление плитки', 1),
(73, 'Технический надзор', 1),
(74, 'Газификация', 1),
(75, 'Изготовление скульптур', 1),
(76, 'Роспись стен', 1),
(77, 'Художественное литье из металла', 1),
(78, 'Лепнина и мозаики', 1),
(79, 'Гипсокартон', 1),
(80, 'Установка карнизов', 1),
(81, 'Чистка труб', 1),
(82, 'Алмазное сверление и резка', 1),
(83, 'Огнезащитная обработка', 1),
(84, 'Столярные и плотницкие работы', 1),
(85, 'Жалюзи', 1),
(86, 'Пошив штор', 1),
(87, 'Маркизы', 1),
(88, 'Антенны', 1),
(89, 'Водоемы и фонтаны', 1),
(90, 'Герметизация фасадов', 1),
(91, 'Изготовление кованых изделий', 1),
(92, 'Другое', 1),
(93, 'Стиральные машины', 2),
(94, 'Холодильники', 2),
(95, 'Телевизоры', 2),
(96, 'Посудомоечные машины', 2),
(97, 'Водонагреватели', 2),
(98, 'Газовые колонки', 2),
(99, 'Кухонные плиты', 2),
(100, 'Ремонт мелкой бытовой техники', 2),
(101, 'Электрооборудование', 2),
(102, 'Кондиционеры', 2),
(103, 'Источники бесперебойного питания', 2),
(104, 'Кофемашины', 2),
(105, 'Силовое оборудование и кабельные линии', 2),
(106, 'Кассовые аппараты', 2),
(107, 'Ремонт промышленного оборудования', 2),
(108, 'Сушильные машины', 2),
(109, 'Садовая техника', 2),
(110, 'Квадрокоптеры', 2),
(111, 'Строительные агрегаты', 2),
(112, 'Промышленные холодильники', 2),
(113, 'Ремонт торговых витрин', 2),
(114, 'Ремонт измерительных приборов', 2),
(115, 'Ремонт торгового оборудования', 2),
(116, 'Ремонт персонального электротранспорта', 2),
(117, 'Фильтры для воды', 2),
(118, 'Мобильные телефоны и планшеты', 2),
(119, 'Автомобильная электроника', 2),
(120, 'Принтеры', 2),
(121, 'Домофоны', 2),
(122, 'Вытяжки', 2),
(123, 'Фото и видеотехника', 2),
(124, 'Аудиотехника', 2),
(125, 'Крупная строительная и сельскохозяйственная техника', 2),
(126, 'Медицинская техника', 2),
(127, 'Другое', 2),
(128, 'Двигатель', 3),
(129, 'Диагностика', 3),
(130, 'Переоборудование транспортных средств', 3),
(131, 'Выхлопная система', 3),
(132, 'Детейлинг', 3),
(133, 'Трансмиссия', 3),
(134, 'Антикоррозийная обработка', 3),
(135, 'Кузовной ремонт', 3),
(136, 'Рулевое управление', 3),
(137, 'Замена стекла', 3),
(138, 'Шиномонтаж', 3),
(139, 'Техническое обслуживание', 3),
(140, 'Покраска', 3),
(141, 'Установка допоборудования', 3),
(142, 'Подвеска', 3),
(143, 'Тормозная система', 3),
(144, 'Ремонт спецтехники', 3),
(145, 'Выездной шиномонтаж', 3),
(146, 'Тюнинг', 3),
(147, 'Мойка и уход за авто', 3),
(148, 'Шиномонтаж грузовых автомобилей', 3),
(149, 'Помощь на дорогах', 3),
(150, 'Промывка топливной системы', 3),
(151, 'Отогрев авто', 3),
(152, 'Ремонт шин и дисков', 3),
(153, 'Сезонное хранение шин', 3),
(154, 'Ошиповка резины', 3),
(155, 'Кондиционеры и отопление', 3),
(156, 'Тюнинг двигателя', 3),
(157, 'Тюнинг подвески', 3),
(158, 'Техническое обслуживание газового оборудования', 3),
(159, 'Сход-развал для грузового авто', 3),
(160, 'Сход-развал', 3),
(161, 'Тонировка и автовинил', 3),
(162, 'Ремонт грузовых авто', 3),
(163, 'Газовое оборудование', 3),
(164, 'Ремонт тентов грузовых авто', 3),
(165, 'Хромирование', 3),
(166, 'Аэрография', 3),
(167, 'Ремонт мототехники', 3),
(168, 'Электрооборудование', 3),
(169, 'Сколы и трещины на стеклах', 3),
(170, 'Другое', 3);

-- --------------------------------------------------------

--
-- Структура таблицы `service`
--

CREATE TABLE `service` (
  `id` bigint(20) NOT NULL,
  `date_time` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `photos_url` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `first_category_id` bigint(20) DEFAULT NULL,
  `second_category_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` bigint(20) DEFAULT NULL,
  `sure_name` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `user_roles`
--

CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `first_category`
--
ALTER TABLE `first_category`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `job`
--
ALTER TABLE `job`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK44hbwxoh2wl8c04rlqgr5va9p` (`first_category_id`),
  ADD KEY `FKmy2lwavxksvujrbe8r4cnefyh` (`second_category_id`),
  ADD KEY `FKihd6m3auwpenduntl3e1opcoq` (`user_id`);

--
-- Индексы таблицы `messages`
--
ALTER TABLE `messages`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKeqc3md8cew4t9a6ea8bmfu592` (`receiver_user_id`),
  ADD KEY `FKmcthksqj41v5iavdb78fhn162` (`sender_user_id`);

--
-- Индексы таблицы `proposals`
--
ALTER TABLE `proposals`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKfomh9vfrupnwuj2w2wopiuech` (`job_id`),
  ADD KEY `FKr42atihsfnn8amyj6muiitdku` (`sender_user_id`);

--
-- Индексы таблицы `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `second_category`
--
ALTER TABLE `second_category`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbo7ndw7jhil4exds7ht7994f1` (`first_category_id`);

--
-- Индексы таблицы `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKfmprinalfkbsiidll09vrkfp1` (`first_category_id`),
  ADD KEY `FKo5w3si7c2odbwfjbah7dbhsbg` (`second_category_id`),
  ADD KEY `FK21kefim0cvfxud7lrcnxctq9r` (`user_id`);

--
-- Индексы таблицы `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `first_category`
--
ALTER TABLE `first_category`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT для таблицы `job`
--
ALTER TABLE `job`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `messages`
--
ALTER TABLE `messages`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `proposals`
--
ALTER TABLE `proposals`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `roles`
--
ALTER TABLE `roles`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT для таблицы `second_category`
--
ALTER TABLE `second_category`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=171;

--
-- AUTO_INCREMENT для таблицы `service`
--
ALTER TABLE `service`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `job`
--
ALTER TABLE `job`
  ADD CONSTRAINT `FK44hbwxoh2wl8c04rlqgr5va9p` FOREIGN KEY (`first_category_id`) REFERENCES `first_category` (`id`),
  ADD CONSTRAINT `FKihd6m3auwpenduntl3e1opcoq` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKmy2lwavxksvujrbe8r4cnefyh` FOREIGN KEY (`second_category_id`) REFERENCES `second_category` (`id`);

--
-- Ограничения внешнего ключа таблицы `messages`
--
ALTER TABLE `messages`
  ADD CONSTRAINT `FKeqc3md8cew4t9a6ea8bmfu592` FOREIGN KEY (`receiver_user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKmcthksqj41v5iavdb78fhn162` FOREIGN KEY (`sender_user_id`) REFERENCES `user` (`id`);

--
-- Ограничения внешнего ключа таблицы `proposals`
--
ALTER TABLE `proposals`
  ADD CONSTRAINT `FKfomh9vfrupnwuj2w2wopiuech` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`),
  ADD CONSTRAINT `FKr42atihsfnn8amyj6muiitdku` FOREIGN KEY (`sender_user_id`) REFERENCES `user` (`id`);

--
-- Ограничения внешнего ключа таблицы `second_category`
--
ALTER TABLE `second_category`
  ADD CONSTRAINT `FKbo7ndw7jhil4exds7ht7994f1` FOREIGN KEY (`first_category_id`) REFERENCES `first_category` (`id`);

--
-- Ограничения внешнего ключа таблицы `service`
--
ALTER TABLE `service`
  ADD CONSTRAINT `FK21kefim0cvfxud7lrcnxctq9r` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKfmprinalfkbsiidll09vrkfp1` FOREIGN KEY (`first_category_id`) REFERENCES `first_category` (`id`),
  ADD CONSTRAINT `FKo5w3si7c2odbwfjbah7dbhsbg` FOREIGN KEY (`second_category_id`) REFERENCES `second_category` (`id`);

--
-- Ограничения внешнего ключа таблицы `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FK55itppkw3i07do3h7qoclqd4k` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
