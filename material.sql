-- phpMyAdmin SQL Dump
-- version 4.3.12
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 2016-11-03 10:59:40
-- 服务器版本： 5.6.23-log
-- PHP Version: 5.6.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `material`
--

-- --------------------------------------------------------

--
-- 表的结构 `material`
--

CREATE TABLE IF NOT EXISTS `material` (
  `id` varchar(255) NOT NULL,
  `ctime` datetime DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `parameter` varchar(255) DEFAULT NULL,
  `total` varchar(255) DEFAULT NULL,
  `projectid` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `material`
--

INSERT INTO `material` (`id`, `ctime`, `location`, `name`, `parameter`, `total`, `projectid`) VALUES
('2000416fdaaa4550960b906d417be720', '2016-11-02 10:35:55', '1', '1', '1', '1', '909de8551738449fbf81be7b9229d988'),
('283d8895b5c54d13bb2a1e5862e7592c', '2016-11-02 10:36:28', '5', '5', '5', '5', '909de8551738449fbf81be7b9229d988'),
('3d98e49f9063481aa35598c35cfbcda7', '2016-11-02 16:45:49', '1', '1', '1', '1', NULL),
('b24883a477be4a32805d0a318948d12f', '2016-11-02 16:45:02', '1', '1', '1', '1', '909de8551738449fbf81be7b9229d988'),
('c91067dc33b948588fa953e1a828b4e4', '2016-11-02 10:36:10', '测试', '测试', '测试', '测试', 'f77eeae99bf34e45afa1c370f0c8c4e6'),
('d07d96d321e94a49888659a9099a2902', '2016-11-02 10:36:18', '测试1', '测试1', '测试1', '测试1', '909de8551738449fbf81be7b9229d988'),
('d751d107f8b244a289f95c98294ddae9', '2016-11-02 10:36:01', '2', '2', '2', '2', 'f77eeae99bf34e45afa1c370f0c8c4e6'),
('e09140476e024aa9b025c4fbff5891dc', '2016-11-02 10:36:04', '3', '3', '3', '3', '909de8551738449fbf81be7b9229d988'),
('edfc8dc7c0ec4a4597cee44af74d5182', '2016-11-02 10:36:25', '4', '4', '4', '4', 'f77eeae99bf34e45afa1c370f0c8c4e6');

-- --------------------------------------------------------

--
-- 表的结构 `project`
--

CREATE TABLE IF NOT EXISTS `project` (
  `id` varchar(255) NOT NULL,
  `ctime` datetime DEFAULT NULL,
  `pname` varchar(255) NOT NULL,
  `projecthead` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `project`
--

INSERT INTO `project` (`id`, `ctime`, `pname`, `projecthead`) VALUES
('909de8551738449fbf81be7b9229d988', '2016-10-28 09:21:09', '人脸识别系统', '周文彪'),
('f77eeae99bf34e45afa1c370f0c8c4e6', '2016-10-28 09:24:04', '智能小车', '张咏乐');

-- --------------------------------------------------------

--
-- 表的结构 `record`
--

CREATE TABLE IF NOT EXISTS `record` (
  `id` varchar(255) NOT NULL,
  `recordctime` datetime DEFAULT NULL,
  `material_record` varchar(255) DEFAULT NULL,
  `project_record` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `record`
--

INSERT INTO `record` (`id`, `recordctime`, `material_record`, `project_record`) VALUES
('29eba5fb060544748ba9a20b05e6ecb0', NULL, NULL, '1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `material`
--
ALTER TABLE `material`
  ADD PRIMARY KEY (`id`), ADD KEY `FKpe2drk46hpcgnt6l8uu7m7crl` (`projectid`);

--
-- Indexes for table `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `record`
--
ALTER TABLE `record`
  ADD PRIMARY KEY (`id`);

--
-- 限制导出的表
--

--
-- 限制表 `material`
--
ALTER TABLE `material`
ADD CONSTRAINT `FKpe2drk46hpcgnt6l8uu7m7crl` FOREIGN KEY (`projectid`) REFERENCES `project` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
