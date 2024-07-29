package javaapplication2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.text.*;

public class JavaApplication2 extends JPanel {

    private int level = 1;

    private Image image;
    private Image image_agac;
    private Image image_ninja1;
    private Image image_ninja2;
    private Image image_ninja3;
    private Image image_ninja4;
    private Image image_sallanaca1;
    private Image image_sallanaca2;

    private Image image_sallanaca3;
    private Image image_sallanaca4;

    private Image image_adsiz;
    private Image image_adsiz2;
    private Image image_knife1;
    private final int WIDTH = 1000;
    private final int HEIGHT = 750;
    private ArrayList<String> basitkelimeler;
    private ArrayList<String> ortakelimeler;
    private ArrayList<String> zorkelimeler;
    private ArrayList<String> cokzorkelimeler;
    private String[] kelimedizi;
    private String[] gizlikelime;
    private String kelime;
    private File kelimeler;
    private JTextField textField;
    private String textFieldValue;
    private boolean kazanildi = false;
    private boolean kazanildiyazi = false;
    private Point knife;
    private Point ninja;
    private String[] knifes;
    private Timer knifeTimer;
    private Timer ninjaTimer;
    private int ninjaFrame = 0;
    private int ninjasayac = 0;
    private int hak = 7;
    private ArrayList<String> harfler;
    private JLabel sureLabel;
    private int gecenSure = 0;
    private int dogru = 0;
    private int yanlıs = 0;
    private Timer sureTimer;

    public JavaApplication2() {
        kelimeler = new File("kelimeler.txt");
        

        this.basitkelimeler = new ArrayList<>(Arrays.asList("elma", "armut", "muz", "çilek", "portakal", "karpuz", "kiraz", "erik", "üzüm", "kavun"));

        this.knifes = new String[hak];
        Random rn = new Random();
        int secim = rn.nextInt(basitkelimeler.size());
        kelime = basitkelimeler.get(secim);
        this.kelimedizi = new String[kelime.length()];
        gizlikelimeOluştur();

        this.ortakelimeler = new ArrayList<>(Arrays.asList("radyasyon",
                "aksiyon",
                "evlilik",
                "balon",
                "tünel",
                "korsan",
                "limon",
                "kahraman",
                "rezervuar",
                "gölgelik",
                "penguen",
                "fil",
                "timsah",
                "sincap",
                "porsuk",
                "gergedan",
                "yunus",
                "zürafa",
                "kanguru",
                "kaplumbağa"));
        System.out.println(ortakelimeler.size());

        this.zorkelimeler = new ArrayList<>(Arrays.asList("kazakistan",
                "yeni zelanda",
                "kamerun",
                "malezya",
                "gine-bissau",
                "nikaragua",
                "surinam",
                "vietnam",
                "bangladeş",
                "lüksemburg",
                "nükleer fizikçi",
                "biyoistatistikçi",
                "kriptolog",
                "dendrolog",
                "astrofizikçi",
                "endokrinolog",
                "kronobiyolog",
                "nanoteknolog",
                "seizmolog"));

        this.cokzorkelimeler = new ArrayList<>(Arrays.asList("damlaya damlaya göl olur.",
                "dost acı söyler.",
                "düşmanın dostu olurmuş.",
                "göz görmeyince gönül katlanır.",
                "hem suçlu, hem güçlü olunmaz.",
                "insan neye benzerse ona türlü türlü gelir.",
                "sakla samanı, gelir zamanı.",
                "yiğit düşerken bellidir.",
                "yüzünde güneş, gönlünde sevda eksik olmasın.",
                "zamanı geldiğinde çocuk bile kıyar kendi canına.",
                "akıllı düşmanı bağırarak uyandırma.",
                "baba oğluna acı çekmesini öğretir.",
                "dala el veren, meyve vermez.",
                "düşenin dostu olmaz.",
                "el elden üstündür.",
                "her doğan gün bir öncekinden güzeldir.",
                "huyu kaba, sofrası araba.",
                "insan öldüğü zaman, eti yenmez.",
                "ne ekersen onu biçersin.",
                "söz gümüşse sükut altındır."));

        System.out.println(kelime);
        // Resmi yükleme
        ImageIcon imageIcon = new ImageIcon("background.png"); // Resmin dosya yolunu verin
        image = imageIcon.getImage();
        ImageIcon imageIcon1 = new ImageIcon("agac.png"); // Resmin dosya yolunu verin
        image_agac = imageIcon1.getImage();
        ImageIcon imageIcon2 = new ImageIcon("ninja 1.png"); // Resmin dosya yolunu verin
        image_ninja1 = imageIcon2.getImage();
        ImageIcon imageIcon20 = new ImageIcon("ninja2.png"); // Resmin dosya yolunu verin
        image_ninja2 = imageIcon20.getImage();
        ImageIcon imageIcon21 = new ImageIcon("ninja3.png"); // Resmin dosya yolunu verin
        image_ninja3 = imageIcon21.getImage();
        ImageIcon imageIcon22 = new ImageIcon("ninja4.png"); // Resmin dosya yolunu verin
        image_ninja4 = imageIcon22.getImage();
        ImageIcon imageIcon3 = new ImageIcon("sallanıcak1.png"); // Resmin dosya yolunu verin
        image_sallanaca1 = imageIcon3.getImage();
//        ImageIcon imageIcon6 = new ImageIcon("sallanıcak2.png"); // Resmin dosya yolunu verin
//        image_sallanaca2 = imageIcon6.getImage();
//        ImageIcon imageIcon7 = new ImageIcon("sallanıcak3.png"); // Resmin dosya yolunu verin
//        image_sallanaca3 = imageIcon7.getImage();
//        ImageIcon imageIcon8 = new ImageIcon("sallanıcak4.png"); // Resmin dosya yolunu verin
//        image_sallanaca4 = imageIcon8.getImage();
        ImageIcon imageIcon4 = new ImageIcon("adsız.png"); // Resmin dosya yolunu verin
        image_adsiz = imageIcon4.getImage();
        ImageIcon imageIcon40 = new ImageIcon("adsız.png"); // Resmin dosya yolunu verin
        image_adsiz2 = imageIcon40.getImage();
        ImageIcon imageIcon5 = new ImageIcon("knife.png"); // Resmin dosya yolunu verin
        image_knife1 = imageIcon5.getImage();

        // TextField oluştur
        textField = new JTextField(20);
        // DocumentFilter oluştur
        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                if (text.matches("[a-zA-ZçÇğĞıİöÖşŞüÜ ]") || text.isEmpty()) { // Türkçe harfler ve boşlukları izin verin
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        this.harfler = new ArrayList<>();

        // TextField'e ActionListener ekle
        textField.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                textFieldValue = textField.getText();

                if (harfler.contains(textFieldValue)) {
                    textField.setText("");
                    JOptionPane.showMessageDialog(null, "bu harfi daha önce kullandınız", "Uyarı", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    harfler.add(textFieldValue);
                    System.out.println(harfler);

                    oyun();

                    repaint();
                    textField.setText("");
                }

            }
        });

        ninjaTimer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (ninjasayac < 9) {
                    ninjasayac++;
                    ninjaFrame = (ninjaFrame + 1) % 4; // 4 kareli bir animasyon döngüsü
                    repaint();
                } else {
                    ninja = null;
                    ninjasayac = 0;
                }

            }
        });
        ninjaTimer.start();
        knifeTimer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveFood();

                repaint();
            }
        });
        knifeTimer.start();

        // Düzen yöneticisini devre dışı bırak
        setLayout(null);

        // TextField'in konumunu ayarla
        textField.setBounds(520, 360, 30, 30); // x, y, genişlik, yükseklik

        // TextField'i panele ekle
        add(textField);
        JButton kelimeekleButton = new JButton("KELİME EKLE");
        kelimeekleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ekle();
                } catch (IOException ex) {
                    Logger.getLogger(JavaApplication2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        kelimeekleButton.setBounds(120, 0, 120, 30);
        add(kelimeekleButton);
        JButton TekraronaButton = new JButton("TEKRAR OYNA");
        TekraronaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });
        TekraronaButton.setBounds(0, 0, 120, 30);
        add(TekraronaButton);
        sureLabel = new JLabel("Geçen Süre: 0");
        sureLabel.setBounds(850, 0, 200, 30); // Konumunu ayarlayın
        add(sureLabel); // Panele ekleyin

        // Geçen süreyi güncellemek için zamanlayıcı oluşturun
        sureTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gecenSure++; // Geçen süreyi artır
                sureLabel.setForeground(Color.WHITE);
                sureLabel.setText("Geçen Süre: " + gecenSure + " saniye");

            }
        });
        sureTimer.start(); // Zamanlayıcıyı başlat

        // Çıkış Yap butonu oluştur
    }

    private void kelimeekle() throws FileNotFoundException, IOException {
        BufferedReader bReader = new BufferedReader(new FileReader(kelimeler));
        String satir;
        while ((satir = bReader.readLine()) != null) {
            if (satir.charAt(0) == '1') {
                int esittirIsaretiKonumu = satir.indexOf(":");
                String sagdakiMetin = satir.substring(esittirIsaretiKonumu + 1);
                System.out.println(sagdakiMetin);
                basitkelimeler.add(sagdakiMetin);
            }
            else if (satir.charAt(0) == '2') {
                int esittirIsaretiKonumu = satir.indexOf(":");
                String sagdakiMetin = satir.substring(esittirIsaretiKonumu + 1);
                System.out.println(sagdakiMetin);
                ortakelimeler.add(sagdakiMetin);
            }
            else if (satir.charAt(0) == '3') {
                int esittirIsaretiKonumu = satir.indexOf(":");
                String sagdakiMetin = satir.substring(esittirIsaretiKonumu + 1);
                zorkelimeler.add(sagdakiMetin);
            }
            else if (satir.charAt(0) == '4') {
                int esittirIsaretiKonumu = satir.indexOf(":");
                String sagdakiMetin = satir.substring(esittirIsaretiKonumu + 1);
                cokzorkelimeler.add(sagdakiMetin);
            }

        }
        System.out.println(basitkelimeler);
        System.out.println(ortakelimeler);
    }

    public static void goruntule1(String file2) throws IOException {
        BufferedReader bReader = new BufferedReader(new FileReader(file2));
        JFrame pencere = new JFrame();
        String satir;
        pencere.setTitle("NOT LİST");
        pencere.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        JTextArea metinAlani = new JTextArea();
        int bir, iki, uc, top = 0, i = 0;

        while ((satir = bReader.readLine()) != null) {
            i++;
            metinAlani.append(i + ". oyundan alınan " + satir + "\n");
            bir = satir.charAt(5) - '0';
            iki = satir.charAt(6) - '0';
            int puan = bir * 10 + iki;
            if (satir.length() > 7) {
                uc = satir.charAt(7) - '0';
                puan = puan * 10 + uc;
            }
            top += puan;
            

        }
        int ort = top / i;
        metinAlani.append("ortalama=" + ort + "\n");

        JScrollPane scrollPane = new JScrollPane(metinAlani);

        pencere.add(scrollPane);

        pencere.pack();
        pencere.setLocationRelativeTo(null);
        pencere.setVisible(true);
    }

    public static void dosyayaEkle(String dosyaAdi, int veri) {
        try (FileWriter fileWriter = new FileWriter(dosyaAdi, true)) {
            String newveri = ("puan=" + veri + "\n");
            fileWriter.write(newveri);
            System.out.println("Veri dosyaya başarıyla eklendi.");
        } catch (IOException e) {
            System.err.println("Dosyaya yazılırken bir hata oluştu: " + e.getMessage());
        }
    }

    private void ekle() throws IOException {
        kelimeekle();
        try (FileWriter fileWriter = new FileWriter(kelimeler, true)) {
            String kelime = JOptionPane.showInputDialog("Ekleyeceğiniz kelime uzunluğuna göre bir levele eklenecektir \n0 ile 8 arası 1.seviye.\n8 ile 12 arası 2.seviye\n12 ile 17 arası 3. seviye\ndaha uzunlar 4. seviye ", "kelimeyi buraya girin");
            if (kelime == null) {
                JOptionPane.showMessageDialog(null, "kelime girmediniz, oyun devam edecektir", "Uyarı", JOptionPane.INFORMATION_MESSAGE);

            } else {
                if (kelime.length() < 8) {
                    if (basitkelimeler.contains(kelime)) {
                        JOptionPane.showMessageDialog(null, "bu kelime zaten var", "Uyarı", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "kelime 1. seviyedeki kelimelere eklenmiştir", "Uyarı", JOptionPane.INFORMATION_MESSAGE);
                        basitkelimeler.add(kelime);
                        fileWriter.write("1. seviye kelime :" + kelime + "\n");
                    }

                } else if (kelime.length() < 12) {
                    if (ortakelimeler.contains(kelime)) {
                        JOptionPane.showMessageDialog(null, "bu kelime zaten var", "Uyarı", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "kelime 2. seviyedeki kelimelere eklenmiştir", "Uyarı", JOptionPane.INFORMATION_MESSAGE);
                        ortakelimeler.add(kelime);
                        fileWriter.write("2. seviye kelime :" + kelime + "\n");
                    }
                } else if (kelime.length() < 17) {
                    if (zorkelimeler.contains(kelime)) {
                        JOptionPane.showMessageDialog(null, "bu kelime zaten var", "Uyarı", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "kelime 3. seviyedeki kelimelere eklenmiştir", "Uyarı", JOptionPane.INFORMATION_MESSAGE);
                        zorkelimeler.add(kelime);
                        fileWriter.write("3. seviye kelime :" + kelime + "\n");
                    }
                } else {
                    if (cokzorkelimeler.contains(kelime)) {
                        JOptionPane.showMessageDialog(null, "bu kelime zaten var", "Uyarı", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "kelime 4. seviyedeki kelimelere eklenmiştir", "Uyarı", JOptionPane.INFORMATION_MESSAGE);
                        cokzorkelimeler.add(kelime);
                        fileWriter.write("4. seviye kelime :" + kelime + "\n");
                    }
                }
            }
            System.out.println("Veri kelimeler dosyaya başarıyla eklendi.");
        } catch (IOException e) {
            System.err.println("Dosyaya yazılırken bir hata oluştu: " + e.getMessage());
        }
        

        // TextField'i panele ekle
    }

    public static void playSound(String soundFilePath) {
        File soundFile = new File(soundFilePath);

        try {
            // Ses dosyasını yükle
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);

            // Ses formatını al
            AudioFormat format = audioStream.getFormat();

            // Ses veri çizgisini oluştur
            DataLine.Info info = new DataLine.Info(Clip.class, format);

            // Ses çizgisini aç
            Clip audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.open(audioStream);
            if(soundFilePath=="ses.wav"){
                audioClip.loop(Clip.LOOP_CONTINUOUSLY);
            // Ses dosyasını çal
                audioClip.start();
            }else{
                audioClip.start();
            }
            

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }

    private void resetGame() {
        JFrame pencere = new JFrame();
        pencere.setTitle("GAME OVER");
        pencere.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        pencere.setLayout(new FlowLayout()); // Butonların yan yana görüntülenmesi için FlowLayout kullanılıyor
        if (dogru + yanlıs > 0) {
            int puan = ((10 * dogru) - (5 * yanlıs) + (100 - gecenSure));
            String dosyaAdi = "output.txt";

            dosyayaEkle(dosyaAdi, puan);

            JLabel puanLabel = new JLabel("Puan: " + puan + "\n");
            // Puanı gösterecek JLabel
            // Kırmızı renk örneği

            pencere.add(puanLabel); // Panele ekle
        }

        JButton tekrarOynaButton = new JButton("Tekrar Oyna");
        tekrarOynaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tekrar oyna butonuna basıldığında oyunu baştan başlat
                level = 1;
                gecenSure = 0;
                kazanildiyazi = false;
                dogru = 0;
                yanlıs = 0;
                harfler.clear();
                hak = 7;
                kazanildi = false;
                Random rn = new Random();
                int secim = rn.nextInt(basitkelimeler.size());
                kelime = basitkelimeler.get(secim);
                gizlikelimeOluştur();
                // Ekranı tekrar çiz
                repaint();
                pencere.dispose(); // Butonlara tıklandığında pencereyi kapat
            }
        });
        pencere.add(tekrarOynaButton);
        JButton istatistikbutonu = new JButton("İSTATİSTİKLER");
        istatistikbutonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dosyaAdi = "output.txt";
                try {
                    // Tekrar oyna butonuna basıldığında oyunu baştan başlat
                    goruntule1(dosyaAdi);
                } catch (IOException ex) {
                    Logger.getLogger(JavaApplication2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        pencere.add(istatistikbutonu);

        JButton cikisYapButton = new JButton("Çıkış Yap");
        cikisYapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Çıkış yap butonuna basıldığında uygulamayı kapat
                System.exit(0);
            }
        });
        pencere.add(cikisYapButton);

        pencere.pack();
        pencere.setLocationRelativeTo(null); // Pencereyi ekranın ortasına yerleştir
        pencere.setVisible(true);
    }

    private void gizlikelimeOluştur()  {
        
        this.gizlikelime = new String[kelime.length()];
        for (int i = 0; i < kelime.length(); i++) {
            if (" ".equals(String.valueOf(kelime.charAt(i)))) {
                gizlikelime[i] = " ";
            } else if ("-".equals(String.valueOf(kelime.charAt(i)))) {
                gizlikelime[i] = "-";
            } else if (".".equals(String.valueOf(kelime.charAt(i)))) {
                gizlikelime[i] = ".";
            } else if (",".equals(String.valueOf(kelime.charAt(i)))) {
                gizlikelime[i] = ",";
            } else {
                gizlikelime[i] = "_";
            }

        }

    }

    private void ninjapleace() {
        int x;
        int y;
        x = 600;
        y = 280;
        ninja = new Point(x, y);
    }

    private void knifepleace() {
        for (int i = 0; i < 7 - hak; i++) {
            Random random = new Random();
            int x;
            int y;

            x = 800;
            y = 300;

            knife = new Point(x, y);

            String val = x + "," + y;
            knifes[i] = val;
        }

    }

    private void moveFood() {
        // Sadece hedefe ulaşmamış bıçakları hareket ettirin
        for (int i = 0; i < 7 - hak; i++) {
            String cell = knifes[i];
            String[] knifeInfo = cell.split(",");
            int x = Integer.parseInt(knifeInfo[0]);
            int y = Integer.parseInt(knifeInfo[1]);

            // Bıçağın mevcut konumu
            Point currentPos = new Point(x, y);

            // Hedef noktası
            Point targetPos = new Point(100, 400); // Sabit hedef noktası (100, 400)
            if (i == 1) {
                targetPos = new Point(260, 550);
            } else if (i == 2) {
                targetPos = new Point(170, 480);
            } else if (i == 3) {
                targetPos = new Point(280, 480);
            } else if (i == 4) {
                targetPos = new Point(220, 480);
            } else if (i == 5) {
                targetPos = new Point(230, 480);
            } else if (i == 6) {
                targetPos = new Point(220, 430);

            } else if (i == 0) {
                targetPos = new Point(170, 550);
            }
            // Eğer bıçak hedefe ulaşmışsa, hareket etmeyi durdurun
            if (!currentPos.equals(targetPos)) {
                // Bıçağı hedefe doğru hareket ettir
                if (x < targetPos.x) {
                    x += 10;
                } else if (x > targetPos.x) {
                    x -= 10;
                }

                if (y < targetPos.y) {
                    y += 10;
                } else if (y > targetPos.y) {
                    y -= 10;
                }

                // Yeni konumu güncelle
                currentPos.setLocation(x, y);

                // Güncellenmiş konumu dizideki ilgili hücreye kaydet
                knifes[i] = x + "," + y;
            }
        }
    }

    private void gameOver() {

        knifeTimer.stop(); // Yemi yavaşlatmak için zamanlayıcıyı durdur

        JOptionPane.showMessageDialog(this, "Game Over! ", "Game Over", JOptionPane.INFORMATION_MESSAGE);
    }

    private void oyun() {
        System.out.println(kelime);
        System.out.println(textFieldValue);
        if (textFieldValue != null) {
            boolean harfDogru = false;
            if (textFieldValue.contains(kelime)) {
                for (int i = 0; i < kelime.length(); i++) {

                    gizlikelime[i] = String.valueOf(textFieldValue.charAt(i));
                    harfDogru = true;

                }
                dogru++;

                harfDogru = true;
            } else {
                for (int i = 0; i < kelime.length(); i++) {
                    if (kelime.charAt(i) == textFieldValue.charAt(0)) {
                        dogru++;

                        gizlikelime[i] = String.valueOf(textFieldValue.charAt(0));
                        harfDogru = true;
                    }
                }

            }

            if (!harfDogru) {
                String soundFilePath = "ninjases.wav";

                // Ses dosyasını çal
                playSound(soundFilePath);
                soundFilePath = "jettses.wav";

                // Ses dosyasını çal
                playSound(soundFilePath);
                hak--;
                yanlıs++;
                knifepleace();
                ninjapleace();
                try {

                    // 3000 milisaniye = 3 saniye
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (hak == 0) {

                resetGame();
                return;
            }
            kazanildi = true;
            for (int i = 0; i < kelime.length(); i++) {
                if (!gizlikelime[i].equals(String.valueOf(kelime.charAt(i)))) {
                    kazanildi = false;
                    break;
                }
            }

            if (kazanildi) {
                if (level == 4) {

                    try {
                        kazanildiyazi = true;
                        // 3000 milisaniye = 3 saniye
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    kazanildi = false;
                    resetGame();
                } else {
                    level++;
                    hak = 7;
                    harfler.clear();
                    switch (level) {
                        case 2:
                            System.out.println(ortakelimeler.size());

                            kelime = ortakelimeler.get(new Random().nextInt(ortakelimeler.size()));
                            gizlikelimeOluştur();
                            break;
                        case 3:

                            kelime = zorkelimeler.get(new Random().nextInt(zorkelimeler.size()));
                            gizlikelimeOluştur();
                            break;
                        case 4:

                            kelime = cokzorkelimeler.get(new Random().nextInt(cokzorkelimeler.size()));
                            gizlikelimeOluştur();
                            break;
                        default:
                            break;
                    }
                    gizlikelimeOluştur();
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Resmi çizme ve şeffaf pikselleri ayarlama
        int x = getWidth() / 2 - WIDTH / 2; // Pencerenin genişliğinin yarısı kadar sola kaydır
        int y = getHeight() / 2 - HEIGHT / 2; // Pencerenin yüksekliğinin yarısı kadar yukarı kaydır

        g.drawImage(image, x, y, WIDTH, HEIGHT, this);
        g.drawImage(image_agac, x + 30, y + 400, WIDTH / 3, HEIGHT / 3, this);

        g.drawImage(image_sallanaca1, x + 150, y + 430, WIDTH / 5 - 30, HEIGHT / 4 - 20, this);

        g.drawImage(image_adsiz, x + 440, y + 100, WIDTH / 2, HEIGHT / 2, this);
        g.drawImage(image_adsiz, x + 20, y + 200, WIDTH / 3, HEIGHT / 3, this);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 15));
        g.drawString("" + "kurtar beni lütfen! ", 70, 230);
        g.drawString("" + "7 yanlış tahmin hakkın var .", 70, 250);
        g.drawString("" + "ninjanın bıçaklarından kurtar . ", 70, 270);
        g.drawString("" + hak + " yanlış tahmin hakkın kaldı . ", 70, 290);
        g.drawString("" + (level) + "/4 level . ", 70, 310);
        g.drawString("" + " her level öncekiden daha zor . ", 70, 330);

        if (ninja == null) {
            g.drawImage(image_ninja1, x + 600, y + 280, WIDTH / 3, HEIGHT / 2, this);
        } else {
            switch (ninjaFrame) {
                case 0:
                    g.drawImage(image_ninja1, x + ninja.x, y + ninja.y, WIDTH / 3, HEIGHT / 2, this);
                    break;
                case 1:
                    g.drawImage(image_ninja2, x + ninja.x, y + ninja.y, WIDTH / 3, HEIGHT / 2, this);
                    break;
                case 2:
                    g.drawImage(image_ninja3, x + ninja.x, y + ninja.y, WIDTH / 3, HEIGHT / 2, this);
                    break;
                case 3:
                    g.drawImage(image_ninja4, x + ninja.x, y + ninja.y, WIDTH / 3, HEIGHT / 2, this);
                    break;

            }

        }

        // Kelimenin harflerini yazdırma
        if (kazanildiyazi) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 150));
            g.drawString("" + "Kazandınız!", 100, 200);
        }
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        int kelimex = 500; // Başlangıç x konumu
        int kelimey = 150; // Başlangıç y konumu

        for (int i = 0; i < kelime.length(); i++) {
            char harf = kelime.charAt(i);
            if (harf == ' ') {
                // Boşluk karakteri bulunduğunda bir sonraki satıra geç
                kelimey += 20; // Yeni satırın y konumunu artır
                kelimex = 500; // x konumunu başlangıç noktasına sıfırla
                g.drawString("" + gizlikelime[i], kelimex, kelimey);
            } else {
                g.drawString("" + gizlikelime[i], kelimex, kelimey);
                kelimex += 20; // x konumunu bir sonraki karakter için artır
            }
        }
        g.drawString("kullanılan harfler :", 500, 300);
        g.drawString("" + harfler, 500, 320);

        if (knifes != null) {
            for (int i = 0; i < 7 - hak; i++) {
                String cell = knifes[i];
                String[] zombiebilgileri = cell.split(",");
                int knifex = Integer.parseInt(zombiebilgileri[0]);
                int knifey = Integer.parseInt(zombiebilgileri[1]);

                knife.x = knifex;
                knife.y = knifey;
                g.drawImage(image_knife1, knife.x, knife.y, 30, 30, this);

            }
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String soundFilePath = "ses.wav";

            // Ses dosyasını çal
            playSound(soundFilePath);
            JFrame frame = new JFrame("ADAM ASMACA");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 750);
            frame.setLocationRelativeTo(null); // Pencereyi ekranda ortada aç

            JavaApplication2 panel = new JavaApplication2();
            frame.getContentPane().add(panel);

            frame.setVisible(true);
        });
    }

}
