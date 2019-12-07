package PracticeBuoi12;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SanPhamController implements ISanPhamController{
    public void getSanPhams (ArrayList<SanPham> sanPhams){
        for (SanPham sp : sanPhams) {
            System.out.println(sp.toString());
        }
    }

    public void inRaSumGiaTriSanPhamTheoDanhMuc(ArrayList<SanPham> sanPhams, String tenDanhMuc){
        double sum = 0;
        for (SanPham sp: sanPhams) {
            if(tenDanhMuc.equals(sp.getTenDanhMuc())){
                sum = sum + sp.getGiaSP()*sp.getSoLuongSP();
            }
        }

        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        String numberAsString = decimalFormat.format(sum);
        System.out.println(numberAsString);
    }

    public String findClosestDanhMucValue(String danhMucFromConsole, ArrayList<String> tenDanhMucs){
        String closestDanhMucVaule = tenDanhMucs.get(0);

        int closestCharNum = 0;
        for(int i =0; i < tenDanhMucs.get(0).length(); i ++){
            if(i >= danhMucFromConsole.length()){
                break;
            }
            if(tenDanhMucs.get(0).toLowerCase().charAt(i) == danhMucFromConsole.toLowerCase().charAt(i)){
                closestCharNum = closestCharNum +1;
            }
        }
        for (String s : tenDanhMucs) {
            int currentCharNum = 0;
            for(int i =0; i < s.length(); i ++){
                if(i >= danhMucFromConsole.length()){
                    break;
                }
                if(s.toLowerCase().charAt(i) == danhMucFromConsole.toLowerCase().charAt(i)){
                    currentCharNum = currentCharNum +1;
                }
            }
            if(currentCharNum >= closestCharNum){
                closestCharNum = currentCharNum;
                closestDanhMucVaule = s;
            }
        }
        return closestDanhMucVaule;
    }

    public void inRaThongTinSanPhamTheoMaSanPham(ArrayList<SanPham> sanPhams, String maSanPham){
        int flag = 0;
        for (SanPham sp: sanPhams) {
            if(maSanPham.equals(sp.getIdSP())){
                System.out.println(sp.toString());
                flag = 1;
            }
        }
        if(flag == 0){
            System.out.println("ma san pham khong khop voi bat ki ma san pham nao trong file data");
        }
    }

    public void sapXepDanhSachSanPhamTheoGiaSanPham(ArrayList<SanPham> sanPhams, int left, int right){
        if (left >= right) return;

        int l = left;
        int r = right;

        SanPham privot = sanPhams.get((right + left ) / 2);

        while ( l <= r ){
            while ( sanPhams.get(l).getGiaSP() < privot.getGiaSP() ){
                l++;
            }
            while ( sanPhams.get(r).getGiaSP() > privot.getGiaSP() ){
                r--;
            }
            if ( l <= r ){
                hoanVi(sanPhams, l++, r--);
            }
        }

        sapXepDanhSachSanPhamTheoGiaSanPham(sanPhams, left, r );

        sapXepDanhSachSanPhamTheoGiaSanPham(sanPhams, l, right);
    }

    private static void hoanVi(ArrayList<SanPham> dsLopHoc, int a, int b){
        SanPham tmp = dsLopHoc.get(a);
        dsLopHoc.set(a, dsLopHoc.get(b));
        dsLopHoc.set(b, tmp);
    }


}
