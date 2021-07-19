import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TP2_Method {
        static Scanner input = new Scanner (System.in);
        static Scanner in = new Scanner (System.in);
        static String name ="-",address="-", 
                        phone="-", status="-", 
                        birth="-", nKTP="-";
        static long numberP, numberK;
        private static SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        public static void main(String []  Args){
            String iLanjut;
            boolean isLanjut = false; // perulangan pertama
            do{
                System.out.println(" DATA DIRI PENGGUNA ");
                System.out.println("======================");
                UName();
                UBirth();
                UNohp();
                System.out.print("Apakah Anda yakin dengan data tersebut? [Y|N]");
                iLanjut = input.nextLine();
                if(iLanjut.equals("Y") || iLanjut.equals("y")){
                    isLanjut = false;
                    boolean iReturn = false; // perulangan kedua
                    do{
                    MData();
                    System.out.print("Masukan Pilihan Anda : ");
                    int pilih = in.nextInt();
                    switch(pilih){
                        //pilihan 1 (LIHAT DATA)
                        case 1:
                        LData();
                        break;

                        //pilihan 2 (EDIT DATA)
                        case 2:
                        boolean iTerus = false; // perulangan ketiga
                        do{
                            PData();
                            System.out.print("Masukan Pilihan Anda : ");
                            int pilihan = in.nextInt();
                                switch(pilihan){
                                    //EDIT NAMA
                                    case 1:
                                    System.out.println(" EDIT NAMA ANDA ");
                                    System.out.println("==================");
                                    UName();
                                    break;
                                    //EDIT ALAMAT
                                    case 2:
                                    System.out.println(" EDIT ALAMAT ANDA ");
                                    System.out.println("==================");
                                    UAlamat();
                                    break;
                                    //EDIT NOMOR HP
                                    case 3:
                                    System.out.println(" EDIT NOMOR HANDPHONE ANDA ");
                                    System.out.println("==================");
                                    UNohp();
                                    break;
                                    //EDIT TANGGAL LAHIR
                                    case 4:
                                    System.out.println(" EDIT TANGGAL LAHIR ANDA ");
                                    System.out.println("==================");
                                    UBirth();
                                    break;
                                    //EDIT STATUS
                                    case 5:
                                    System.out.println(" EDIT STATUS ANDA ");
                                    System.out.println("==================");
                                    UStatus();
                                    break;
                                    //EDIT NOMOR KTP
                                    case 6:
                                    System.out.println(" EDIT NOMOR KTP ANDA ");
                                    System.out.println("==================");
                                    UNoKTP();
                                    break;
                                }
                                    if(pilihan == 7){ // Kondisi Keluar ke Menu Utama
                                        iTerus = false;
                                    }
                                    else if ( pilihan > 7 || pilihan < 1){ // kondisi pilihan bukan 1-7
                                        System.out.println("Error Input, Masukan [1-7]");
                                        iTerus = true;
                                    }
                        }while(iTerus == true);
                        break;
                    }



                    if(pilih == 3){ //Kondisi Keluar
                        iReturn = true;
                    }
                    else if(pilih > 3 || pilih < 1){ // Kondisi pilih bukan 1-3
                        System.out.println("Error Input, Masukan [1-3]");
                        iReturn = false;
                    }
                  }while(iReturn == false);
                }

                else if(iLanjut.equals("N") || iLanjut.equals("n")){
                    isLanjut = true; // Kondisi Inputan Nilai "N"
                }
                else{
                    System.out.println("Error Input, Masukan Nilai Y|N");
                    isLanjut = true; // Kondisi Inputan selain "Y|N"
                }
            }while(isLanjut == true);
        }

        //Method
    
        static void MData(){
            System.out.println("PILIH MENU ");
            System.out.println("==================");
            System.out.println("1. Lihat Data Diri ");
            System.out.println("2. Update Data Diri ");
            System.out.println("3. Keluar ");
            System.out.println("==================");
        }
        static void LData(){
            System.out.println(" BIODATA PENGGUNA ");
            System.out.println("==================");
            System.out.println("Nama : "+name);
            System.out.println("Alamat : "+address);
            System.out.println("Nomor Handphone : "+numberP);
            System.out.println("Tgl Lahir : "+birth);
            System.out.println("Status : "+status);
            System.out.println("Nomor KTP : "+numberK);
            System.out.println("==================");
        }
        static void PData(){
            System.out.println(" PILIH EDIT DATA ");
            System.out.println("==================");
            System.out.println("1. Nama ");
            System.out.println("2. Alamat ");
            System.out.println("3. Nomor Handphone ");
            System.out.println("4. Tgl Lahir ");
            System.out.println("5. Status ");
            System.out.println("6. Nomor KTP ");
            System.out.println("7. Cancel ");
            System.out.println("==================");
        }
        static void UName(){
            boolean ExName = true;
            do{
                System.out.print("Masukan Nama Anda : ");
                name = input.nextLine();
            try{
                boolean Bname = name.matches("[a-zA-Z](.*)");
                if(Bname == false){
                    throw new Exception();
                }
                ExName = false;
               }catch(Exception ex){ 
                  System.out.println("Silahkan coba lagi. ("+ " Input yang dimasukan tidak sesuai " 
                   +  "nilai harus berupa String !)");
                  ExName = true;
                }
            }while(ExName);
        }
        static void UAlamat(){
           boolean ExAddress = true;
            do{
                System.out.print("Masukan Alamat Anda : ");
                address = input.nextLine();
            try{
                boolean Baddress = address.matches("[a-zA-Z](.*)");
                if(Baddress == false){
                    throw new Exception();
                }
                ExAddress = false;
               }catch(Exception ex){ 
                  System.out.println("Silahkan coba lagi. ("+ " Input yang dimasukan tidak sesuai " 
                   +  "nilai harus berupa String !)");
                  ExAddress = true;
                }
            }while(ExAddress);
        }
        static void UNohp(){
            boolean ExPhone = true;
            do{
                System.out.print("Masukan No Handphone : ");
                phone = input.nextLine();
            try{
                numberP = Long.parseLong(phone);
                ExPhone = false;
               }catch(Exception ex){ 
                  System.out.println("Silahkan coba lagi. ("+ " Input yang dimasukan tidak sesuai " 
                   +  "nilai harus berupa Angka !)");
                  ExPhone = true;
                }
            }while(ExPhone);
        }
        private static void UBirth(){
            boolean BBirth = true;
            do{
                System.out.print("Masukan Tanggal Lahir Anda [dd-MMM-yyyy]: ");
                birth = input.nextLine();
                try{
                    Date date = formatter.parse(birth);
                    BBirth = false;
                }catch(Exception ex){
                    System.out.println("Silahkan coba lagi. Format yang anda masukan salah HARUS [dd-MMM-yyyy] ");
                    BBirth =true;
                }
            }while(BBirth);
            
        }
        static void UStatus(){
            boolean ExStatus = true;
            do{
                System.out.print("Masukan Status Anda [Belum Kawin/Kawin]: ");
                status = input.nextLine();
            try{
                boolean BStatus = status.matches("[a-zA-Z](.*)");
                if(BStatus == false){
                    throw new Exception();
                }
                ExStatus = false;
               }catch(Exception ex){ 
                  System.out.println("Silahkan coba lagi. ("+ " Input yang dimasukan tidak sesuai " 
                   +  "nilai harus berupa String !)");
                  ExStatus = true;
                }
            }while(ExStatus);
        }
        static void UNoKTP(){
            boolean ExKTP = true;
            do{
                System.out.print("Masukan No KTP  : ");
                nKTP = input.nextLine();
            try{
                numberK = Long.parseLong(nKTP);
                ExKTP = false;
               }catch(Exception ex){
                  System.out.println("Silahkan coba lagi. ("+ " Input yang dimasukan tidak sesuai " 
                   +  "nilai harus berupa Angka !)");
                  ExKTP = true;
                }
            }while(ExKTP);
        }
}
