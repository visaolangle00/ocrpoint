-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th9 15, 2021 lúc 04:57 PM
-- Phiên bản máy phục vụ: 10.4.21-MariaDB
-- Phiên bản PHP: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `studentpoint`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lophocphan`
--

CREATE TABLE `lophocphan` (
  `lop_id` varchar(255) NOT NULL,
  `gv_id` int(11) NOT NULL,
  `monhoc_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `lophocphan`
--

INSERT INTO `lophocphan` (`lop_id`, `gv_id`, `monhoc_id`) VALUES
('CSE320K1', 1, 'CSEA'),
('CSE320K2', 2, 'CSEA'),
('CSE322K1', 1, 'CSEC'),
('CSE322K2', 2, 'CSEC'),
('CSE324K1', 3, 'CSER'),
('CSE326K1', 3, 'CSED');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `monhoc`
--

CREATE TABLE `monhoc` (
  `tenmon` varchar(255) NOT NULL,
  `monhoc_id` varchar(255) NOT NULL,
  `tkb` varchar(255) NOT NULL,
  `sotinchi` int(11) NOT NULL,
  `gv_id` int(11) NOT NULL,
  `lich` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `monhoc`
--

INSERT INTO `monhoc` (`tenmon`, `monhoc_id`, `tkb`, `sotinchi`, `gv_id`, `lich`) VALUES
('Program Android', 'CSEA', 'Lesson 1-2 P.303-A9', 3, 1, 'MON'),
('Program Android', 'CSEA1', 'Lesson 6-7 P.303-A9', 3, 2, 'TUE'),
('Program C', 'CSEC', 'Lesson 4-5-6 P.303-A9', 3, 1, 'TUE'),
('Program C', 'CSEC1', 'Lesson 5-6-7 P.303-A9', 3, 2, 'FRI'),
('Program Database', 'CSED', 'Lesson 9-10 P.302-A2', 3, 3, 'THU'),
('Program Java', 'CSEJ', 'Lesson 3-6 P.302.A1', 3, 1, 'THU'),
('Program Java', 'CSEJ1', 'Lesson 4-6 P.302.A1', 3, 2, 'SAT'),
('Program Ruby', 'CSER', 'Lesson 1-2 P.303-A2', 3, 3, 'MON'),
('Application Algorithm', 'CSETT', 'Lesson 4-5 P.302-A2', 3, 1, 'SUN'),
('Application Algorithm', 'CSETT1', 'Lesson 7-8 P.302-A2', 3, 2, 'SUN');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sv`
--

CREATE TABLE `sv` (
  `masv` int(11) NOT NULL,
  `tensv` varchar(255) NOT NULL,
  `sv_id` varchar(255) NOT NULL,
  `lopql` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `sv`
--

INSERT INTO `sv` (`masv`, `tensv`, `sv_id`, `lopql`) VALUES
(1000, 'Nguyen Van A', 'TH1000', '57TH1'),
(1001, 'Nguyen Van Huy', 'TH1001', '57TH2'),
(1002, 'Tran Van Huyen', 'TH1002', '57TH2'),
(1003, 'Doi Quan Huy', 'TH1003', '57TH2'),
(1004, 'Bui Quang Huy', 'TH1004', '57TH2'),
(1005, 'Tran Van Tuyet', 'TH1005', '57TH1'),
(1006, 'Tran Huy Bao', 'TH1006', '57TH1'),
(1007, 'Tran Thi Nhi', 'TH1007', '57TH1'),
(1008, 'Do Van An', 'TH1008', '57TH2'),
(1009, 'Do Van Hieu', 'TH1009', '57TH2'),
(1010, 'Doi Van Xuan', 'TH1010', '57TH2'),
(2000, 'Do Van Duc', 'TH2000', '58TH2'),
(2001, 'Do Trung Hieu', 'TH2001', '58TH2'),
(2002, 'Tran Van Quan', 'TH2002', '58TH2'),
(2003, 'Nguyen Huy Binh', 'TH2003', '58TH2'),
(2004, 'Bui Cong Nam', 'TH2004', '58TH2');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sv_hocphan`
--

CREATE TABLE `sv_hocphan` (
  `diem_gk` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL,
  `sv_id` varchar(255) NOT NULL,
  `lop_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `sv_hocphan`
--

INSERT INTO `sv_hocphan` (`diem_gk`, `id`, `sv_id`, `lop_id`) VALUES
(8, 23, 'TH1003', 'CSE320K2'),
(7, 214, 'TH1003', 'CSE324K1'),
(1, 215, 'TH2003', 'CSE320K2'),
(7, 217, 'TH1005', 'CSE322K1'),
(NULL, 223, 'TH1006', 'CSE322K1'),
(NULL, 224, 'TH1007', 'CSE322K1'),
(NULL, 225, 'TH1008', 'CSE322K1'),
(8, 226, 'TH1009', 'CSE322K1'),
(NULL, 227, 'TH1010', 'CSE322K1'),
(NULL, 228, 'TH2001', 'CSE322K1'),
(8, 234, 'TH1003', 'CSE322K1'),
(8, 235, 'TH1007', 'CSE320K2');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan_gv`
--

CREATE TABLE `taikhoan_gv` (
  `gv_id` int(11) NOT NULL,
  `dangkyboi` int(11) NOT NULL,
  `taikhoan_id` int(11) NOT NULL,
  `tentaikhoan` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `matkhau` varchar(255) NOT NULL,
  `dienthoai` varchar(255) NOT NULL,
  `gioitinh` varchar(255) NOT NULL,
  `trangthai1` varchar(255) NOT NULL,
  `trangthai2` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `taikhoan_gv`
--

INSERT INTO `taikhoan_gv` (`gv_id`, `dangkyboi`, `taikhoan_id`, `tentaikhoan`, `email`, `matkhau`, `dienthoai`, `gioitinh`, `trangthai1`, `trangthai2`) VALUES
(1, 1000, 1996, 'Nguyen Van Ta', 'visaolangle00@gmail.com', 'yfeid', '0123456012', 'Male', 'Yes1', 'No2'),
(2, 1996, 123, 'Nguyen Huy', 'thanhtrung@wru.vn', 'nguyenhiep', '0968120', 'Male', 'Yes1', 'Yes2'),
(3, 123, 213213, 'Nguyen Thanh Trung', 'gstt101@gmail.com', 'test1996', '0981081650', 'Male', 'Yes1', 'No2'),
(7, 1000, 1000, 'Nguyen Thanh Long', 'thanhlong123@gmail.com', 'testtest', '0123456012', 'Male', 'Yes1', 'No2');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `lophocphan`
--
ALTER TABLE `lophocphan`
  ADD PRIMARY KEY (`lop_id`),
  ADD KEY `gv_id` (`gv_id`),
  ADD KEY `monhoc_id` (`monhoc_id`);

--
-- Chỉ mục cho bảng `monhoc`
--
ALTER TABLE `monhoc`
  ADD PRIMARY KEY (`monhoc_id`),
  ADD KEY `gv_id` (`gv_id`);

--
-- Chỉ mục cho bảng `sv`
--
ALTER TABLE `sv`
  ADD PRIMARY KEY (`sv_id`);

--
-- Chỉ mục cho bảng `sv_hocphan`
--
ALTER TABLE `sv_hocphan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `sv_id` (`sv_id`),
  ADD KEY `lop_id` (`lop_id`);

--
-- Chỉ mục cho bảng `taikhoan_gv`
--
ALTER TABLE `taikhoan_gv`
  ADD PRIMARY KEY (`gv_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `sv_hocphan`
--
ALTER TABLE `sv_hocphan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=236;

--
-- AUTO_INCREMENT cho bảng `taikhoan_gv`
--
ALTER TABLE `taikhoan_gv`
  MODIFY `gv_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `lophocphan`
--
ALTER TABLE `lophocphan`
  ADD CONSTRAINT `lophocphan_ibfk_1` FOREIGN KEY (`gv_id`) REFERENCES `taikhoan_gv` (`gv_id`),
  ADD CONSTRAINT `lophocphan_ibfk_2` FOREIGN KEY (`monhoc_id`) REFERENCES `monhoc` (`monhoc_id`);

--
-- Các ràng buộc cho bảng `monhoc`
--
ALTER TABLE `monhoc`
  ADD CONSTRAINT `monhoc_ibfk_1` FOREIGN KEY (`gv_id`) REFERENCES `taikhoan_gv` (`gv_id`);

--
-- Các ràng buộc cho bảng `sv_hocphan`
--
ALTER TABLE `sv_hocphan`
  ADD CONSTRAINT `sv_hocphan_ibfk_1` FOREIGN KEY (`sv_id`) REFERENCES `sv` (`sv_id`),
  ADD CONSTRAINT `sv_hocphan_ibfk_2` FOREIGN KEY (`lop_id`) REFERENCES `lophocphan` (`lop_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
