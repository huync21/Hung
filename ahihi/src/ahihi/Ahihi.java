
package ahihi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Ahihi {

    
    public static void main(String[] args) {
        //1
        ArrayList<SinhVien> list=new ArrayList<>();
        
        try {
            Scanner s=new Scanner(new File("SV.INP"));
            while(s.hasNextLine()){
                int count=0;
                try{
                SinhVien sv=new SinhVien();
                count++;
                sv.setMaSV(Integer.parseInt(s.nextLine()));
                count++;
                sv.setTen(s.nextLine());
                count++;
                sv.setLop(s.nextLine());
                count++;
                sv.setDtb(Double.parseDouble(s.nextLine()));
                
                list.add(sv);
                } catch (MaSVException ex) {
                    System.out.println(ex);
                } catch (TenException ex) {
                    System.out.println(ex);
                } catch (LopException ex) {
                    System.out.println(ex);
                } catch (DtbException ex) {
                    System.out.println(ex);
                }
                catch(Exception e){
                    System.out.println(e);
                }
                
                if(count<4){
                    for(int i=0;i<4-count;i++){
                        if(s.hasNextLine())
                            s.nextLine();
                    }
                }
                
                
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        
        //2
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        
        //3
        Collections.sort(list, new Comparator<SinhVien>(){
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                if(o1.getDtb()<o2.getDtb()) return 1;
                else if(o1.getDtb()==o2.getDtb()) return 0;
                else return -1;
            }
            
        });
        
        try {
            PrintStream ps=new PrintStream(new File("SX.OUT"));
            for(int i=0;i<list.size();i++){
                ps.println(list.get(i));
        }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        
        //4
        Collections.sort(list, new Comparator<SinhVien>(){
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                StringTokenizer st1=new StringTokenizer(o1.getTen());
                StringTokenizer st2=new StringTokenizer(o2.getTen());
                String ten1=null;
                String ten2=null;
                while(st1.hasMoreTokens()){
                    ten1=st1.nextToken();
                }
                while(st2.hasMoreTokens()){
                    ten2=st2.nextToken();
                }
                
                return ten1.compareTo(ten2);
            }
            
        });
        
        try {
            PrintStream ps=new PrintStream(new File("XEPLOAI.OUT"));
            ps.println("=========================");
            ps.println("GIOI: ");
            for(int i=0;i<list.size();i++){
                double diem=list.get(i).getDtb();
                if(diem>8) ps.println(list.get(i));
            }
            
            ps.println("=========================");
            ps.println("KHA: ");
            for(int i=0;i<list.size();i++){
                double diem=list.get(i).getDtb();
                if(diem>=7 && diem<=8) ps.println(list.get(i));
            }
            
            ps.println("=========================");
            ps.println("TRUNG BINH: ");
            for(int i=0;i<list.size();i++){
                double diem=list.get(i).getDtb();
                if(diem>=5 && diem<7) ps.println(list.get(i));
            }
            
            ps.println("=========================");
            ps.println("YEU: ");
            for(int i=0;i<list.size();i++){
                double diem=list.get(i).getDtb();
                if(diem<5) ps.println(list.get(i));
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        
        
    }
    
}
