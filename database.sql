CREATE DATABASE WEBMAYVITINH;
USE WEBMAYVITINH;

-- Create TaiKhoan table
CREATE TABLE TaiKhoan (
    id_nguoidung INT AUTO_INCREMENT PRIMARY KEY,
    ten_dangnhap VARCHAR(50) NOT NULL,
    matkhau VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    vai_tro ENUM('admin', 'Khách Hàng', 'Nhân Viên') NOT NULL DEFAULT 'Khách Hàng',
    trang_thai ENUM('OFF', 'ON') NOT NULL DEFAULT 'ON'
);

-- Create KhachHang table
CREATE TABLE KhachHang (
    id_khachhang INT AUTO_INCREMENT PRIMARY KEY,
    ho_ten VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    dia_chi VARCHAR(255),
    so_dien_thoai INT NOT NULL,
    id_nguoidung INT,
    FOREIGN KEY (id_nguoidung) REFERENCES TaiKhoan(id_nguoidung) ON DELETE CASCADE
);

-- Create SanPham table
CREATE TABLE SanPham (
    id_sanpham INT AUTO_INCREMENT PRIMARY KEY,
    ten_sanpham VARCHAR(100) NOT NULL,
    thuong_hieu VARCHAR(50),
    gia DECIMAL(10, 2) NOT NULL,
    mo_ta TEXT,
    so_luong INT,
    link_anh VARCHAR(255)
);

-- Create DonHang table
CREATE TABLE DonHang (
    id_donhang INT AUTO_INCREMENT PRIMARY KEY,
    id_khachhang INT NOT NULL,
    id_sanpham INT,
    so_luong INT,
    ngay_dat DATE NOT NULL,
    trang_thai ENUM('dang_xu_ly', 'da_giao', 'da_nhan', 'huy') NOT NULL DEFAULT 'dang_xu_ly',
    hinh_thuc_thanh_toan ENUM('trả tiền khi nhận hàng ', 'momo') NOT NULL DEFAULT 'trả tiền khi nhận hàng',
    tong_tien DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (id_khachhang) REFERENCES KhachHang(id_khachhang) ON DELETE CASCADE,
    FOREIGN KEY (id_sanpham) REFERENCES SanPham(id_sanpham) ON DELETE CASCADE
);

-- Create Cart table
CREATE TABLE Cart (
    id_cart INT AUTO_INCREMENT PRIMARY KEY,
    id_sanpham INT,
    gia DECIMAL(10,2),
    so_luong INT,
    id_nguoidung INT,
    link_anh VARCHAR(255),
    FOREIGN KEY (id_sanpham) REFERENCES SanPham(id_sanpham) ON DELETE CASCADE,
    FOREIGN KEY (id_nguoidung) REFERENCES TaiKhoan(id_nguoidung) ON DELETE CASCADE
);

-- Create DanhMuc table
CREATE TABLE DanhMuc (
    id_danhmuc INT AUTO_INCREMENT PRIMARY KEY,
    ten_danhmuc VARCHAR(100) NOT NULL,
    mo_ta TEXT
);

-- Create DanhGia table
CREATE TABLE DanhGia (
    id_danhgia INT AUTO_INCREMENT PRIMARY KEY,
    id_sanpham INT NOT NULL,
    id_taikhoan INT NOT NULL,
    danh_gia INT NOT NULL,
    binh_luan TEXT,
    ngay_danhgia TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_sanpham) REFERENCES SanPham(id_sanpham) ON DELETE CASCADE,
    FOREIGN KEY (id_taikhoan) REFERENCES TaiKhoan(id_nguoidung) ON DELETE CASCADE
);
INSERT INTO TaiKhoan (ten_dangnhap, matkhau, email, vai_tro,trang_thai) 
VALUES ('admin', 'admin@123', 'admin@example.com', 'admin','ON'),
	   ('user1', 'password1', 'user1@example.com', 'Khách Hàng','OFF'),
       ('user2', 'password2', 'user2@example.com', 'Khách Hàng','ON');
       
-- danh mục

-- Insert products for HP
INSERT INTO SanPham (ten_sanpham, thuong_hieu, gia, mo_ta, so_luong, link_anh) 
VALUES 
('Desktop HP Envy', 'HP', 1200.00, 'HP Envy Desktop with 16GB RAM and 1TB HDD', 5, 'hp1.jpg'),
('Laptop HP Spectre x360', 'HP', 1300.00, 'HP Spectre x360 with 16GB RAM and 512GB SSD', 6, 'hp1.jpg'),
('Desktop HP Omen 30L', 'HP', 1600.00, 'HP Omen 30L Gaming Desktop with 32GB RAM and 1TB SSD', 4, 'hp1.jpg'),
('Laptop HP Pavilion 15', 'HP', 700.00, 'HP Pavilion 15 with 8GB RAM and 256GB SSD', 12, 'hp1.jpg'),
('Desktop HP Z2 Mini', 'HP', 1500.00, 'HP Z2 Mini Workstation with 32GB RAM and 1TB SSD', 3, 'hp1.jpg'),
('Laptop HP EliteBook 850', 'HP', 1400.00, 'HP EliteBook 850 with 16GB RAM and 512GB SSD', 7, 'hp2.jpg'),
('Desktop HP ProDesk 600', 'HP', 900.00, 'HP ProDesk 600 G6 with 8GB RAM and 256GB SSD', 8, 'hp2.jpg'),
('Laptop HP Envy 13', 'HP', 1000.00, 'HP Envy 13 with 16GB RAM and 512GB SSD', 9, 'hp2.jpg'),
('Laptop HP Envy x360', 'HP', 1100.00, 'HP Envy x360 with 16GB RAM and 1TB SSD', 5, 'hp2.jpg'),
('Desktop HP EliteDesk 800', 'HP', 1800.00, 'HP EliteDesk 800 G5 with 64GB RAM and 2TB SSD', 2, 'hp2.jpg');

-- Insert products for Mac
INSERT INTO SanPham (ten_sanpham, thuong_hieu, gia, mo_ta, so_luong, link_anh) 
VALUES 
('Laptop MacBook Air', 'Apple', 1200.00, 'MacBook Air with M1 chip, 8GB RAM, and 256GB SSD', 10, 'mac1.jpg'),
('Laptop MacBook Pro 13', 'Apple', 1500.00, 'MacBook Pro 13 with M1 chip, 8GB RAM, and 512GB SSD', 8, 'mac1.jpg'),
('Laptop MacBook Pro 16', 'Apple', 2500.00, 'MacBook Pro 16 with M1 Pro chip, 16GB RAM, and 1TB SSD', 5, 'mac1.jpg'),
('Desktop iMac 24', 'Apple', 1700.00, 'iMac 24-inch with M1 chip, 8GB RAM, and 512GB SSD', 7, 'mac1.jpg'),
('Desktop iMac 27', 'Apple', 2200.00, 'iMac 27-inch with Intel i9, 32GB RAM, and 1TB SSD', 3, 'mac1.jpg'),
('Laptop MacBook Pro 14', 'Apple', 2000.00, 'MacBook Pro 14 with M1 Pro chip, 16GB RAM, and 1TB SSD', 4, 'mac2.jpg'),
('Desktop Mac Mini', 'Apple', 1000.00, 'Mac Mini with M1 chip, 8GB RAM, and 256GB SSD', 12, 'mac2.jpg'),
('Laptop MacBook Pro 13 (Intel)', 'Apple', 1700.00, 'MacBook Pro 13 with Intel i5, 16GB RAM, and 1TB SSD', 6, 'mac2.jpg'),
('Desktop Mac Pro', 'Apple', 6000.00, 'Mac Pro with Intel Xeon, 64GB RAM, and 2TB SSD', 2, 'mac2.jpg'),
('Laptop MacBook Air (Intel)', 'Apple', 1400.00, 'MacBook Air with Intel i5, 8GB RAM, and 512GB SSD', 9, 'mac2.jpg');

DELIMITER //

CREATE TRIGGER after_insert_donhang
AFTER INSERT ON DonHang
FOR EACH ROW
BEGIN
    DECLARE quantity INT;
    
    -- Lấy số lượng sản phẩm từ DonHang
    SELECT so_luong INTO quantity FROM DonHang WHERE id_donhang = NEW.id_donhang;
    
    -- Kiểm tra nếu số lượng sản phẩm còn lớn hơn 1 thì giảm số lượng
    IF quantity > 1 THEN
        UPDATE SanPham
        SET so_luong = so_luong - quantity
        WHERE id_sanpham = NEW.id_sanpham;
    END IF;
END //

DELIMITER ;



DELIMITER //

CREATE TRIGGER after_delete_donhang
AFTER DELETE ON DonHang
FOR EACH ROW
BEGIN
    DECLARE quantity INT;
    
    -- Lấy trạng thái đơn hàng từ DonHang
    SELECT trang_thai, so_luong INTO @trang_thai, @so_luong FROM DonHang WHERE id_donhang = OLD.id_donhang;
    
    -- Kiểm tra nếu đơn hàng bị hủy ('huy') thì tăng lại số lượng sản phẩm
    IF @trang_thai = 'huy' THEN
        UPDATE SanPham
        SET so_luong = LEAST(so_luong + @so_luong, 255)  -- Giới hạn số lượng tối đa là 255 (nếu cần)
        WHERE id_sanpham = OLD.id_sanpham;
    END IF;
END //

DELIMITER ;