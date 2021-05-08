--tạo database	
create database DA1_QLTV
--tạo bảng admin
create table Admin(
	Username varchar(50) not null primary key,
	Password varchar(50) not null,
	Ten nvarchar(50) not null
)
--tạo bảng sinh viên
create table SinhVien(
	MaSV varchar(50) not null primary key,
	Password varchar(50) not null,
	HoTen nvarchar(50) not null,
	NgaySinh date not null,
	GioiTinh bit not null,
	DiaChi nvarchar(50) not null,
	SDT varchar(11) not null,
	Email nvarchar(50) not null
)
--tạo bảng thể loại sách
create table TheLoaiSach(
	MaTheLoai varchar(10) not null primary key,
	TenTheLoai nvarchar(50) not null,
	ViTri nvarchar(50) not null
)
--tạo bảng sách
create table Sach(
	MaSach varchar(10) not null primary key,
	TenSach nvarchar(50) not null,
	MaTheLoai varchar(10) not null,
	TacGia nvarchar(50) not null,
	SoLuong int not null,
	NXB nvarchar(50) not null,
	NgayNhap date not null,
	NDTT nvarchar(100) not null,
	Hinh nvarchar(50) not null,

	foreign key (MaTheLoai) references TheLoaiSach(MaTheLoai)
)
--tạo bảng phiếu mượn
create table PhieuMuon(
	MaPhieuMuon int IDENTITY (1,1) primary key,
	MaSV varchar(50) not null,
	MaSach varchar(10) not null,
	SoLuong int not null,
	NgayMuon date DEFAULT GETDATE() not null,
	NgayHenTra date DEFAULT (GETDATE() + 10) not null,

	foreign key (MaSV) references SinhVien(MaSV),
	foreign key (MaSach) references Sach(MaSach)
)
--Chèn dữ liệu bảng admin
insert into Admin values('s','s','Song'),
						('t','t','Thanh'),
						('q','q','Quy')
select * from Admin
--Chèn dữ liệu bảng sinh viên
insert into SinhVien values ('PH00001','123',N'Đặng Tuấn Anh','1/12/2001',0,N'Hà Nội','0943456753','tuananh@fpt.edu.vn'),
							('PH00002','123',N'Đàm Yến Nhi','2/22/2002',1,N'Cao Bằng','0998767898','yennhi@fpt.edu.vn'),
							('PH00003','123',N'Bùi Phương Thảo','5/14/1997',1,N'Bắc Kạn','0912312334','phuongthao@fpt.edu.vn'),
							('PH00004','123',N'Đỗ Thùy Linh','6/15/1996',1,N'Sơn La','0945645667','thuylinh@fpt.edu.vn'),
							('PH00005','123',N'Trịnh Thiên Trường','7/21/2000',0,N'Quảng Ninh','0965656578','thientruong@fpt.edu.vn'),
							('PH00006','123',N'Nguyễn Trọng Minh','8/19/1998',0,N'Quảng Nam','0909876789','trongminh@fpt.edu.vn'),
							('PH00007','123',N'Bùi Gia Hân','9/25/1999',1,N'Huế','09375849543','giahan@fpt.edu.vn'),
							('PH00008','123',N'Nguyễn Hùng Anh','10/16/1997',0,N'Nghệ An','0977718273','hunganh@fpt.edu.vn'),
							('PH00009','123',N'Phạm Văn Đạt','11/20/1995',0,N'Nha Trang','09312398754','dat09@fpt.edu.vn'),
							('PH00010','123',N'Trịnh Diệp Lam','12/29/1999',1,N'Hải Dương','0994738999','dieplam@fpt.edu.vn'),
							('PH00011','123',N'Huỳnh Như','11/18/1997',1,N'Hải Phòng','0994977799','nhu@fpt.edu.vn')
insert into SinhVien values ('PH00012','123',N'Đặng Tiến Đông','1/12/2001',0,N'Hà Nội','0943451253','tiendong@fpt.edu.vn'),
							('PH00013','123',N'Huỳnh Tiểu Bảo','2/22/2002',1,N'Cao Bằng','0991767898','tieubao@fpt.edu.vn'),
							('PH00014','123',N'Nguyễn Thùy Linh','6/15/1996',1,N'Sơn La','0945215667','thuy1linh@fpt.edu.vn'),
							('PH00015','123',N'Cao Bá Trường','7/21/2000',0,N'Quảng Ninh','0965126578','batruong@fpt.edu.vn'),
							('PH00016','123',N'Nguyễn Phú Minh','8/19/1998',0,N'Quảng Nam','0909336789','phuminh@fpt.edu.vn'),
							('PH00017','123',N'Bùi Thị Quỳnh','9/25/1999',1,N'Huế','09375849313','thiquynh@fpt.edu.vn'),
							('PH00018','123',N'Phan Hùng Anh','10/16/1997',0,N'Nghệ An','0933718273','hunganh2@fpt.edu.vn'),
							('PH00019','123',N'Nguyễn Văn Đạt','11/20/1995',0,N'Nha Trang','09311298754','dat090@fpt.edu.vn'),
							('PH00020','123',N'Ngọc Diệp Lan','12/29/1999',1,N'Hải Dương','0994567999','dieplan@fpt.edu.vn'),
							('PH00021','123',N'Huỳnh Như Ngọc','11/18/1997',1,N'Hải Phòng','0994557799','nhungoc@fpt.edu.vn')
insert into SinhVien values ('PH00022','123',N'Đặng Tiến Nam','1/12/2001',0,N'Hà Nội','0943455253','tiennam@fpt.edu.vn'),
							('PH00023','123',N'Huỳnh Tuất','2/22/2002',1,N'Cao Bằng','0991765898','tuat@fpt.edu.vn'),
							('PH00024','123',N'Nguyễn Linh','6/15/1996',1,N'Sơn La','0945255667','linh@fpt.edu.vn'),
							('PH00025','123',N'Bùi Trường','7/21/2000',0,N'Quảng Ninh','0965146578','truong@fpt.edu.vn'),
							('PH00026','123',N'Nguyễn Phú Giáp','8/19/1998',0,N'Quảng Nam','0904336789','phugiap@fpt.edu.vn'),
							('PH00027','123',N'Bùi Thị Yến','9/25/1999',1,N'Huế','09375849213','thiyen@fpt.edu.vn'),
							('PH00028','123',N'Phan Hùng Quách','10/16/1997',0,N'Nghệ An','0936718273','hungquach@fpt.edu.vn'),
							('PH00029','123',N'Phạm Văn Đạt','11/20/1995',0,N'Nha Trang','09311798754','dat0910@fpt.edu.vn'),
							('PH00030','123',N'Ngọc Diệp Vấn','12/29/1999',1,N'Hải Dương','0994568899','diepvan@fpt.edu.vn'),
							('PH00031','123',N'Huỳnh Như Ngọc Anh','11/18/1997',1,N'Hải Phòng','0991557799','nhungocanh@fpt.edu.vn')
select * from SinhVien
--Chèn dữ liệu bảng thể loại sách
insert into TheLoaiSach values ('MTL0001',N'Kinh dị',N'Tủ số 1'),
								('MTL0002',N'Nước ngoài',N'Tủ số 2'),
								('MTL0003',N'Trinh thám',N'Tủ số 3'),
								('MTL0004',N'Công nghệ thông tin',N'Tủ số 4'),
								('MTL0005',N'Kỹ năng sống',N'Tủ số 5'),
								('MTL0006',N'Kinh Tế - Xã hội',N'Tủ số 3'),
								('MTL0007',N'Trẻ Em',N'Tủ số 2'),
								('MTL0008',N'Nhiếp ảnh',N'Tủ số 6'),
								('MTL0009',N'Truyện',N'Tủ số 6'),
								('MTL00010',N'Hôn nhân',N'Tủ số 6')
insert into TheLoaiSach values ('MTL00021',N'Thiếu Nhi',N'Tủ số 7'),
								('MTL00012',N'Khoa học',N'Tủ số 8'),
								('MTL00013',N'Mỹ Thuật',N'Tủ số 8'),
								('MTL00014',N'Thẩm Mỹ',N'Tủ số 9'),
								('MTL00015',N'Kỹ Năng Làm Việc',N'Tủ số 9'),
								('MTL00016',N'Đạo Đức',N'Tủ số 9'),
								('MTL00017',N'Viễn Thông',N'Tủ số 3'),
								('MTL00018',N'Cơ Khí',N'Tủ số 1'),
								('MTL00019',N'Làm Đẹp',N'Tủ số 4'),
insert into TheLoaiSach values('MTL00020',N'Giáo Dục',N'Tủ số 5')
select * from TheLoaiSach
--Chèn dữ liệu bảng sách
insert into Sach values ('MS0001',N'Im lặng','MTL0001',N'Phèn',8,N'NXB1','01/12/2021',N'bình thường','ms1.jpg'),
						('MS0002',N'I Love You','MTL0002',N'Kelvin',18,N'NXB AhPufl','02/20/2021',N'bình thường','ms2.jpg'),
						('MS0003',N'Sherlock Holmes','MTL0003',N'NXB Arthur Conan Doyle',11,'NXB3','02/22/2021',N'bình thường','ms3.jpg'),
						('MS0004',N'Lập trình C#','MTL0004',N'Cóc',20,N'NXB FPT','01/14/2021',N'bình thường','ms4.jpg'),
						('MS0005',N'Mẹ ma','MTL0001',N'Mama chuê',19,N'NXB Ghost','02/17/2021',N'bình thường','ms5.png'),
						('MS0006',N'Làm giàu không khó','MTL0006',N'Phanh',4,'NXB Việt Nam','12/19/2020',N'bình thường','ms6.jpg'),
						('MS0007',N'Tom & Jerry','MTL0007',N'Kim đồng',10,N'NXB Cartoon','02/20/2020',N'bình thường','ms7.jpg'),
						('MS0008',N'Bắt trọn khoảnh khắc','MTL0008',N'Phính',10,N'NXB Điện Ảnh','09/22/2020',N'bình thường','ms8.jpg'),
						('MS0009',N'Nghìn lẻ 1 đêm','MTL0009',N'ALibaab',12,N'NXB Thế Giới','08/21/2020',N'bình thường','ms9.jpg'),
						('MS00010',N'Sau kết hôn','MTL00010',N'Ò ó o',17,N'NXB Văn Hóa','05/17/2020',N'bình thường','ms10.jpg')
select * from Sach 
--Chèn dữ liệu bảng phiếu mượn
insert into PhieuMuon values ('PH00001','MS0001','1','3/1/2021','3/11/2021'),
							('PH00002','MS0002',1,'3/1/2021','3/11/2021'),
							('PH00003','MS0003',1,'3/2/2021','3/12/2021'),
							('PH00004','MS0004',1,'3/2/2021','3/12/2021'),
							('PH00005','MS0005',2,'3/3/2021','3/13/2021'),
							('PH00006','MS0006',1,'3/4/2021','3/14/2021'),
							('PH00007','MS0007',2,'3/5/2021','3/15/2021'),
							('PH00008','MS0008',2,'3/6/2021','3/17/2021'),
							('PH00009','MS0009',2,'3/8/2021','3/18/2021'),
							('PH00010','MS0007',3,'3/7/2021','3/17/2021'),
							('PH00003','MS0003',3,'3/6/2021','3/16/2021'),
							('PH00005','MS0002',3,'3/11/2021','3/21/2021'),
							('PH00008','MS0006',4,'3/12/2021','3/22/2021'),
							('PH00009','MS0003',4,'3/14/2021','3/24/2021'),
							('PH00002','MS0001',1,'3/19/2021','3/29/2021')
insert into PhieuMuon values ('PH00011','MS0001','1','3/1/2021','3/11/2021'),
							('PH00012','MS0002',1,'3/1/2021','3/11/2021'),
							('PH00013','MS0003',1,'3/2/2021','3/12/2021'),
							('PH00014','MS0004',1,'3/2/2021','3/12/2021'),
							('PH00015','MS0005',2,'3/3/2021','3/13/2021'),
							('PH00016','MS0006',1,'3/4/2021','3/14/2021'),
							('PH00017','MS0007',2,'3/5/2021','3/15/2021'),
							('PH00018','MS0008',2,'3/6/2021','3/17/2021'),
							('PH00019','MS0009',2,'3/8/2021','3/18/2021'),
							('PH00010','MS0007',3,'3/7/2021','3/17/2021'),
							('PH00023','MS0003',3,'3/6/2021','3/16/2021'),
							('PH00015','MS0002',3,'3/11/2021','3/21/2021'),
							('PH00018','MS0006',4,'3/12/2021','3/22/2021'),
							('PH00019','MS0003',4,'3/14/2021','3/24/2021'),
							('PH00012','MS0001',1,'3/19/2021','3/29/2021')
Select * from PhieuMuon
Select * from Sach where TenSach like '%S%'


-- Stored 1 tìm theo mã thể loại
CREATE PROC sp_MaTheLoaiSach(@MaTheLoai varchar(10)) 
AS BEGIN 
 	Select Tls.MaTheLoai, TenTheLoai, ViTri, MaSach, TenSach, SoLuong
	from TheLoaiSach tls join Sach s on tls.MaTheLoai = s.MaTheLoai 
	where tls.MaTheLoai = @MaTheLoai
	order by SoLuong desc
END 
exec sp_MaTheLoaiSach 'MTL0001'

-- Stored 2 
CREATE PROC sp_TheLoaiSach
AS BEGIN 
 	Select Tls.MaTheLoai, TenTheLoai, ViTri, MaSach, TenSach, SoLuong
	from TheLoaiSach tls join Sach s on tls.MaTheLoai = s.MaTheLoai 
	order by SoLuong desc
END 
exec sp_TheLoaiSach

-- Stored 3 tìm vị trí theo tủ 
CREATE PROC sp_ViTriTheLoaiSach(@ViTri nvarchar(50)) 
AS BEGIN 
 	Select Tls.MaTheLoai, TenTheLoai, ViTri, MaSach, TenSach, SoLuong
	from TheLoaiSach tls join Sach s on tls.MaTheLoai = s.MaTheLoai 
	where ViTri = @ViTri
	order by SoLuong desc
END
exec sp_ViTriTheLoaiSach  N'Tủ số 3'

--Stored 4 đếm số lượng sách theo mã thể loại
CREATE PROC sp_soSachTLS(@MaTheLoai varchar(10)) 
AS BEGIN 
 	Select SUM(SoLuong) tongSachTLS from Sach
	where MaTheLoai = @MaTheLoai
END 
exec sp_soSachTLS  'MTL0001'

--Stored 5 - đếm số lượng sách tại tủ
CREATE PROC sp_soSachViTriTLS(@ViTri nvarchar(50)) 
AS BEGIN 
 	Select SUM(SoLuong) tongSachViTriTLS
	from TheLoaiSach tls join Sach s on tls.MaTheLoai = s.MaTheLoai 
	where ViTri = @ViTri
END 
exec sp_soSachViTriTLS  N'Tủ số 3'
exec sp_ViTriTheLoaiSach  N'Tủ số 3'

--Stored 6 tổng số lượng thể loại sách theo mã thể loại
CREATE PROC sp_soTheLoaiTLS(@MaTheLoai varchar(10)) 
AS BEGIN 
 	Select COUNT(tls.MaTheLoai) soTheLoaiTLS
from TheLoaiSach tls join Sach s on tls.MaTheLoai = s.MaTheLoai 
	where tls.MaTheLoai = @MaTheLoai
END 
exec sp_soTheLoaiTLS  'MTL0001'
exec sp_MaTheLoaiSach 'MTL0001'

--Stored 7 tổng số thể loại sách tại tủ
CREATE PROC sp_soTheLoaiViTriTLS(@ViTri nvarchar(50)) 
AS BEGIN 
 	Select count(MaTheLoai) soTheLoaiViTriTLS
	from TheLoaiSach 
	where ViTri = @ViTri
END 
exec sp_soTheLoaiViTriTLS  N'Tủ số 3'
exec sp_soSachViTriTLS  N'Tủ số 3'
exec sp_ViTriTheLoaiSach  N'Tủ số 3'

--Stored 8
CREATE PROC sp_TongTheLoaiTLS
AS BEGIN 
 	Select count(MaTheLoai) TongTheLoaiTLS from TheLoaiSach
END 
exec sp_TongTheLoaiTLS

--Stored 8 tìm sv theo giới tính
CREATE PROC sp_GioiTinhSV(@GioiTinh bit)
AS BEGIN 
 	Select * from SinhVien where GioiTinh = @GioiTinh
END 
exec sp_GioiTinhSV 0
exec sp_GioiTinhSV 1

--Stored 9 tổng sv theo giới tính
CREATE PROC sp_tongGioiTinhSV(@GioiTinh bit)
AS BEGIN 
 	Select COUNT(GioiTinh) tongGioiTinhSV
	from SinhVien where GioiTinh = @GioiTinh
END 
exec sp_tongGioiTinhSV 0
exec sp_tongGioiTinhSV 1

--Stored 10
CREATE PROC sp_tongSV
AS BEGIN 
 	Select COUNT(MaSV) tongSV
	from SinhVien 
END 
exec sp_tongSV

--Stored 11 Số lượng sách giảm dần trong khoảng tg 
CREATE PROC sp_NgaySachGiam(@ngayBD varchar(50), @ngayKT varchar(50))
AS BEGIN 
 	Select * from Sach
	where ngaynhap >= @ngayBD and ngaynhap <= @ngayKT
	order by SoLuong desc
END 
exec sp_NgaySachGiam '2020-10-29', '2021-06-29'

--Stored 12 Số lượng sách tăng dần trong khoảng tg 
CREATE PROC sp_NgaySachTang(@ngayBD varchar(50), @ngayKT varchar(50))
AS BEGIN 
 	Select * from Sach
	where ngaynhap >= @ngayBD and ngaynhap <= @ngayKT
	order by SoLuong asc
END 
exec sp_NgaySachTang '2020-10-29', '2021-06-29'

--Stored 13 tổng sách theo khoảng tg
CREATE PROC sp_TongSachNgaySach(@ngayBD varchar(50), @ngayKT varchar(50))
AS BEGIN 
 	Select sum(SoLuong) TongNgaySach
	from Sach
	where ngaynhap >= @ngayBD and ngaynhap <= @ngayKT
END 
exec sp_TongSachNgaySach '2020-12-19', '2021-1-12'
exec sp_NgaySachTang '2020-10-29', '2021-06-29'

--Stored 14
CREATE PROC sp_TongSach
AS BEGIN 
 	Select sum(SoLuong) TongSach from Sach
END 
exec sp_TongSach

--Stored 15
CREATE PROC sp_PhieuMuon
AS BEGIN 
 	Select MaPhieuMuon, pm.MaSV, sv.HoTen, pm.MaSach, s.TenSach, pm.SoLuong, NgayMuon, NgayHenTra
	from PhieuMuon pm join SinhVien sv on pm.MaSV = sv.MaSV
	join Sach s on pm.MaSach = s.MaSach
END 
exec sp_PhieuMuon

-- Stored 16 tìm phiếu mượn theo mã sv
CREATE PROC sp_MaSVPM(@MaSV varchar(50)) 
AS BEGIN 
 	Select MaPhieuMuon, pm.MaSV, sv.HoTen, pm.MaSach, s.TenSach, pm.SoLuong, NgayMuon, NgayHenTra
	from PhieuMuon pm join SinhVien sv on pm.MaSV = sv.MaSV
	join Sach s on pm.MaSach = s.MaSach
	where sv.MaSV = @MaSV
END 
exec sp_MaSVPM 'PH00001'

-- Stored 17 tìm sl sv đã mượn theo mã sv
CREATE PROC sp_soSachSVPM(@MaSV varchar(50)) 
AS BEGIN 
 	Select sum(SoLuong) soSachSVPM, MaSV from PhieuMuon
	where MaSV = @MaSV
	group by MaSV
END 
exec sp_soSachSVPM 'PH00001'
exec sp_soSachSVPM 'PH00002'

-- Stored 18 tìm mã pm theo mã sách
CREATE PROC sp_MaSachPM(@MaSach varchar(10)) 
AS BEGIN 
 	Select MaPhieuMuon, pm.MaSV, sv.HoTen, pm.MaSach, s.TenSach, pm.SoLuong, NgayMuon, NgayHenTra
	from PhieuMuon pm join SinhVien sv on pm.MaSV = sv.MaSV
	join Sach s on pm.MaSach = s.MaSach
	where s.MaSach = @MaSach
END 
exec sp_MaSachPM 'MS0001'

-- Stored 19 đếm sl sv theo mã sách
CREATE PROC sp_soSVMuonSachPM(@MaSach varchar(10)) 
AS BEGIN 
 	Select COUNT(MaSV) tongSVMuonSach
	from PhieuMuon
	where MaSach = @MaSach
END 
exec sp_soSVMuonSachPM 'MS0001'

-- Stored 20
CREATE PROC sp_TongSachSVMuon
AS BEGIN 
 	Select sum(SoLuong) TongSachSVMuon from PhieuMuon
END 
exec sp_TongSachSVMuon

-- Stored 21
CREATE PROC sp_SVMuonNhieuSachNhat
AS BEGIN 
 	Select  pm.MaSV, sv.HoTen, sum(pm.SoLuong) SVMuonNhieuSachNhat
	from PhieuMuon pm join SinhVien sv on pm.MaSV = sv.MaSV
	join Sach s on pm.MaSach = s.MaSach
	group by pm.MaSV, sv.HoTen
	order by sum(pm.SoLuong) desc
END 
exec sp_SVMuonNhieuSachNhat

-- Stored 22
CREATE PROC sp_SVMuonItSachNhat
AS BEGIN 
 	Select  pm.MaSV, sv.HoTen, sum(pm.SoLuong) SVMuonItSachNhat
	from PhieuMuon pm join SinhVien sv on pm.MaSV = sv.MaSV
	join Sach s on pm.MaSach = s.MaSach
	group by pm.MaSV, sv.HoTen
	order by sum(pm.SoLuong) asc
END 
exec sp_SVMuonItSachNhat

-- Stored 23
CREATE PROC sp_SachMuonNhieuNhat
AS BEGIN 
 	Select  pm.MaSach, s.TenSach, sum(pm.SoLuong) SachMuonNhieuNhat
	from PhieuMuon pm join Sach s on pm.MaSach = s.MaSach
	group by pm.MaSach,  s.TenSach
	order by sum(pm.SoLuong) desc
END 
exec sp_SachMuonNhieuNhat

-- Stored 24
CREATE PROC sp_SachMuonItNhat
AS BEGIN 
 	Select  pm.MaSach, s.TenSach, sum(pm.SoLuong) SachMuonItNhat
	from PhieuMuon pm join Sach s on pm.MaSach = s.MaSach
	group by pm.MaSach,  s.TenSach
	order by sum(pm.SoLuong) asc
END 
exec sp_SachMuonItNhat

-- Stored 25
CREATE PROC sp_SVConHanTraSach
AS BEGIN 
 	Select MaPhieuMuon, pm.MaSV, sv.HoTen, pm.MaSach, s.TenSach, pm.SoLuong, NgayMuon, NgayHenTra
	from PhieuMuon pm join SinhVien sv on pm.MaSV = sv.MaSV
	join Sach s on pm.MaSach = s.MaSach
	where NgayHenTra > (select GETDATE())
END 
exec sp_SVConHanTraSach

-- Stored 26
CREATE PROC sp_SVQuaHanTraSach
AS BEGIN 
 	Select MaPhieuMuon, pm.MaSV, sv.HoTen, pm.MaSach, s.TenSach, pm.SoLuong, NgayMuon, NgayHenTra
	from PhieuMuon pm join SinhVien sv on pm.MaSV = sv.MaSV
	join Sach s on pm.MaSach = s.MaSach
	where NgayHenTra < (select GETDATE())
END 
exec sp_SVQuaHanTraSach

-- Stored 27
CREATE PROC sp_TongSVConHanTraSach
AS BEGIN 
 	Select COUNT(DISTINCT MaSV) TongSVConHanTraSach 
	from PhieuMuon
	where NgayHenTra > (select GETDATE())
END 
exec sp_TongSVConHanTraSach

-- Stored 28
CREATE PROC sp_TongSVQuaHanTraSach
AS BEGIN 
 	Select COUNT(DISTINCT MaSV) TongSVQuaHanTraSach
	from PhieuMuon
	where NgayHenTra < (select GETDATE())
END 
exec sp_TongSVQuaHanTraSach

-- Stored 29
CREATE PROC sp_TongSoPhieuConHanTraSach
AS BEGIN 
 	Select COUNT(MaPhieuMuon) TongSoPhieuConHanTraSach
	from PhieuMuon
	where NgayHenTra > (select GETDATE())
END 
exec sp_TongSoPhieuConHanTraSach

-- Stored 30
CREATE PROC sp_TongSoPhieuQuaHanTraSach
AS BEGIN 
 	Select COUNT(MaPhieuMuon) TongSoPhieuQuaHanTraSach
	from PhieuMuon
	where NgayHenTra < (select GETDATE())
END
exec sp_TongSoPhieuQuaHanTraSach

-- Stored 31
CREATE PROC sp_TongPM
AS BEGIN 
 	Select COUNT(MaPhieuMuon) TongPM
	from PhieuMuon
END 
exec sp_TongPM

-- Stored 33
CREATE PROC sp_SVChuaMuonSach
AS BEGIN 
 	Select sv.MaSV, Password, HoTen, NgaySinh, GioiTinh, DiaChi, SDT, Email
	from SinhVien sv full join PhieuMuon pm on sv.MaSV = pm.MaSV
	where pm.MaSV IS NULL
END 
exec sp_SVChuaMuonSach

-- Stored 34
CREATE PROC sp_SVDaMuonSach
AS BEGIN 
 	Select DISTINCT pm.MaSV, Password, HoTen, NgaySinh, GioiTinh, DiaChi, SDT, Email
	from SinhVien sv join PhieuMuon pm on sv.MaSV = pm.MaSV
END 
exec sp_SVDaMuonSach

-- Stored 35
CREATE PROC sp_TongSVChuaMuonSach
AS BEGIN 
 	Select COUNT(sv.MaSV) TongSVChuaMuonSach
	from SinhVien sv full join PhieuMuon pm on sv.MaSV = pm.MaSV
	where pm.MaSV IS NULL
END 
exec sp_TongSVChuaMuonSach

-- Stored 36
CREATE PROC sp_TongSVDaMuonSach
AS BEGIN 
 	Select COUNT(DISTINCT pm.MaSV) TongSVDaMuonSach
	from SinhVien sv join PhieuMuon pm on sv.MaSV = pm.MaSV
END
exec sp_TongSVDaMuonSach

-- Stored 37
CREATE PROC sp_SachMuonNhieuNhatSVUI
AS BEGIN 
 	Select  pm.MaSach, s.TenSach, sum(pm.SoLuong) SachMuonNhieuNhatSVUI
	from PhieuMuon pm join Sach s on pm.MaSach = s.MaSach
	group by pm.MaSach,  s.TenSach
	order by sum(pm.SoLuong) desc
END 
exec sp_SachMuonNhieuNhat

-- Stored 38
CREATE PROC sp_SachMuonItNhatSVUI
AS BEGIN 
 	Select  pm.MaSach, s.TenSach, sum(pm.SoLuong) SachMuonItNhatSVUI
	from PhieuMuon pm join Sach s on pm.MaSach = s.MaSach
	group by pm.MaSach,  s.TenSach
	order by sum(pm.SoLuong) asc
END 
exec sp_SachMuonItNhatSVUI


exec sp_SachMuonItNhat
select * from phieumuon