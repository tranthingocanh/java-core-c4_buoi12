package PracticeBuoi12;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SanPham {
    private String idSP;
    private String tenSP;
    private double giaSP;
    private int soLuongSP;
    private String idDanhMuc;
    private String tenDanhMuc;
    private String tenCongTy;
    private Date ngayNhapHang;

    public SanPham(String idSP, String tenSP, double giaSP, int soLuongSP, String idDanhMuc, String tenDanhMuc, String tenCongTy, Date ngayNhapHang) {
        this.idSP = idSP;
        this.tenSP = tenSP;
        this.giaSP = giaSP;
        this.soLuongSP = soLuongSP;
        this.idDanhMuc = idDanhMuc;
        this.tenDanhMuc = tenDanhMuc;
        this.tenCongTy = tenCongTy;
        this.ngayNhapHang = ngayNhapHang;
    }

    public String getIdSP() {
        return idSP;
    }

    public void setIdSP(String idSP) {
        this.idSP = idSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(double giaSP) {
        this.giaSP = giaSP;
    }

    public int getSoLuongSP() {
        return soLuongSP;
    }

    public void setSoLuongSP(int soLuongSP) {
        this.soLuongSP = soLuongSP;
    }

    public String getIdDanhMuc() {
        return idDanhMuc;
    }

    public void setIdDanhMuc(String idDanhMuc) {
        this.idDanhMuc = idDanhMuc;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public String getTenCongTy() {
        return tenCongTy;
    }

    public void setTenCongTy(String tenCongTy) {
        this.tenCongTy = tenCongTy;
    }

    public Date getNgayNhapHang() {
        return ngayNhapHang;
    }

    public void setNgayNhapHang(Date ngayNhapHang) {
        this.ngayNhapHang = ngayNhapHang;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "idSP='" + idSP + '\'' +
                ", tenSP='" + tenSP + '\'' +
                ", giaSP='" + formatGiaSP(giaSP) + '\'' +
                ", soLuongSP=" + soLuongSP +
                ", idDanhMuc='" + idDanhMuc + '\'' +
                ", tenDanhMuc='" + tenDanhMuc + '\'' +
                ", tenCongTy='" + tenCongTy + '\'' +
                ", ngayNhapHang=" + convertDate2String(ngayNhapHang) +
                '}';
    }

    private static String convertDate2String(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
        return dateFormat.format(date);
    }

    private static String formatGiaSP(double giaSP){
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        return decimalFormat.format(giaSP);
    }
}
