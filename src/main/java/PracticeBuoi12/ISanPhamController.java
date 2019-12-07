package PracticeBuoi12;

import java.util.ArrayList;

public interface ISanPhamController {
    public void getSanPhams (ArrayList<SanPham> sanPhams);
    public void inRaSumGiaTriSanPhamTheoDanhMuc(ArrayList<SanPham> sanPhams, String tenDanhMuc);
    public String findClosestDanhMucValue(String danhMucFromConsole, ArrayList<String> tenDanhMucs);
    public void inRaThongTinSanPhamTheoMaSanPham(ArrayList<SanPham> sanPhams, String maSanPham);
    public void sapXepDanhSachSanPhamTheoGiaSanPham(ArrayList<SanPham> sanPhams, int left, int right);
}
