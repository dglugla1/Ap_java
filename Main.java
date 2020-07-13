package sample;

import javafx.application.Application;
import javafx.css.PseudoClass;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import java.io.FileInputStream;
import javafx.scene.image.*;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main extends Application {

    Scene scena1,scena2;

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane okno = new GridPane();
        Scene scena1 = new Scene(okno, 1100, 1000);
        primaryStage.initStyle(StageStyle.UNDECORATED);

        class produkt {
            public String s;

            public produkt(String s) {
                this.s = s;
            }

            public Label tworz() throws FileNotFoundException {
                FileInputStream p1 = new FileInputStream(this.s);
                Image f1 = new Image(p1);
                ImageView ivp1 = new ImageView(f1);
                Label rys = new Label("", ivp1);
                return rys;
            }

        }

        List<Integer> liczby=new LinkedList<Integer>();
        for(int i=0;i<15;i++) {
            Integer numer = 0;
            liczby.add(numer);
        }

        class etykiety {
            public Integer i;
            public Label lal;
            public etykiety(Integer i){
                this.i=i;
            }
            public Label tworz(){
                this.lal= new Label(""+this.i);
                this.lal.setTextFill(Color.web("black"));
                this.lal.setFont(new Font("Arial", 25));
                this.lal.setMinWidth(29);
                return this.lal;
            }
        }
        List<etykiety> lista2 = new LinkedList<etykiety>();
        for(int i=0;i<15;i++){
            etykiety lal = new etykiety(liczby.get(i));
            lista2.add(lal);
        }

        List<produkt> lista = new LinkedList<produkt>();
        List<Label> labelki = new LinkedList<Label>();
        for (int i = 0; i < 15; i++) {
            lista.add(new produkt("C:\\Users\\Dell\\IdeaProjects\\untitled4\\src\\sample\\p" + i + ".png"));
            labelki.add(lista.get(i).tworz());
        }


        Button zamknij = new Button();
        zamknij.setId("zamknij");
        zamknij.setMinSize(20, 20);
        zamknij.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());
        zamknij.setOnAction(zamknij1 ->
        {
            primaryStage.close();
        });
        Button minimum = new Button();
        minimum.setId("zwin");
        minimum.setMinSize(20, 20);
        minimum.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());
        minimum.setOnAction(minimum1 ->
        {
            primaryStage.setIconified(true);
        });

        HBox przyciski = new HBox();
        przyciski.setMinWidth(1100);
        przyciski.setPrefHeight(28);
        przyciski.setId("przyciski");
        przyciski.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());
        przyciski.setStyle("-fx-background-color:rgb(222, 222, 222);");
        przyciski.setAlignment(Pos.CENTER_RIGHT);
        przyciski.setSpacing(10);
        przyciski.getChildren().addAll(minimum, zamknij);
        okno.add(przyciski, 0, 0, 3, 1);

        HBox stopka = new HBox();
        stopka.setMinWidth(1100);
        stopka.setPrefHeight(28);
        stopka.setStyle("-fx-background-color:rgb(222, 222, 222);");
        okno.add(stopka, 0, 10, 3, 1);


        FileInputStream input = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\untitled4\\src\\sample\\tlo.png");
        Image i = new Image(input);
        ImageView iw = new ImageView(i);
        Label rys = new Label("", iw);
        okno.add(rys, 0, 2, 3, 1);

        HBox bok1= new HBox();
        bok1.setStyle("-fx-background-color:rgb(255, 255, 255);");
        okno.add(bok1, 0, 1, 1, 1);

        HBox bok2= new HBox();
        bok2.setStyle("-fx-background-color:rgb(255, 255, 255);");
        okno.add(bok2, 2, 1, 1, 1);


        Button kategoria1 = new Button();
        kategoria1.setId("kategoria1");
        kategoria1.setMinSize(900, 150);
        kategoria1.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());

        Button kategoria2 = new Button();
        kategoria2.setId("kategoria2");
        kategoria2.setMinSize(900, 150);
        kategoria2.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());

        Button kategoria3 = new Button();
        kategoria3.setId("kategoria3");
        kategoria3.setMinSize(900, 150);
        kategoria3.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());

        Button kategorie = new Button();
        kategorie.setId("kategorie");
        kategorie.setAlignment(Pos.BOTTOM_CENTER);
        kategorie.setMinSize(270, 100);
        kategorie.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());

        Button wszystkie = new Button();
        wszystkie.setId("wszystkie");
        wszystkie.setMinSize(270, 100);
        wszystkie.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());

        Button koszyk = new Button();
        koszyk.setId("koszyk");
        koszyk.setMinSize(100, 100);
        koszyk.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());

        FileInputStream logo = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\untitled4\\src\\sample\\logo.png");
        Image l = new Image(logo);
        ImageView iw2 = new ImageView(l);
        iw2.setImage(l);

        HBox naglowek = new HBox();
        naglowek.setMinWidth(900);
        naglowek.setPrefHeight(100);
        naglowek.setId("naglowek");
        naglowek.setSpacing(50);
        naglowek.getChildren().addAll(iw2, kategorie, wszystkie, koszyk);
        naglowek.setStyle("-fx-background-color:rgb(255, 255, 255);");
        okno.add(naglowek, 1, 1, 1, 1);


        FileInputStream produkt1a = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\untitled4\\src\\sample\\p0.png");
        Image prod1a = new Image(produkt1a);
        ImageView pro1a = new ImageView(prod1a);
        pro1a.setImage(prod1a);
        FileInputStream produkt2a = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\untitled4\\src\\sample\\p1.png");
        Image prod2a = new Image(produkt2a);
        ImageView pro2a = new ImageView(prod2a);
        pro2a.setImage(prod2a);
        FileInputStream produkt3a = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\untitled4\\src\\sample\\p2.png");
        Image prod3a = new Image(produkt3a);
        ImageView pro3a = new ImageView(prod3a);
        pro3a.setImage(prod3a);
        FileInputStream produkt4a = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\untitled4\\src\\sample\\p3.png");
        Image prod4a = new Image(produkt4a);
        ImageView pro4a = new ImageView(prod4a);
        pro4a.setImage(prod4a);
        FileInputStream produkt5a = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\untitled4\\src\\sample\\p4.png");
        Image prod5a = new Image(produkt5a);
        ImageView pro5a = new ImageView(prod5a);
        pro5a.setImage(prod5a);
        FileInputStream produkt6a = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\untitled4\\src\\sample\\p5.png");
        Image prod6a = new Image(produkt6a);
        ImageView pro6a = new ImageView(prod6a);
        pro6a.setImage(prod6a);
        FileInputStream produkt7a = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\untitled4\\src\\sample\\p6.png");
        Image prod7a = new Image(produkt7a);
        ImageView pro7a = new ImageView(prod7a);
        pro7a.setImage(prod7a);
        FileInputStream produkt8a = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\untitled4\\src\\sample\\p7.png");
        Image prod8a = new Image(produkt8a);
        ImageView pro8a = new ImageView(prod8a);
        pro8a.setImage(prod8a);
        FileInputStream produkt9a = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\untitled4\\src\\sample\\p8.png");
        Image prod9a = new Image(produkt9a);
        ImageView pro9a = new ImageView(prod9a);
        pro9a.setImage(prod9a);
        FileInputStream produkt10a = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\untitled4\\src\\sample\\p9.png");
        Image prod10a = new Image(produkt10a);
        ImageView pro10a = new ImageView(prod10a);
        pro10a.setImage(prod10a);
        FileInputStream produkt11a = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\untitled4\\src\\sample\\p10.png");
        Image prod11a = new Image(produkt11a);
        ImageView pro11a = new ImageView(prod11a);
        pro11a.setImage(prod11a);
        FileInputStream produkt12a = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\untitled4\\src\\sample\\p11.png");
        Image prod12a = new Image(produkt12a);
        ImageView pro12a = new ImageView(prod12a);
        pro12a.setImage(prod12a);
        FileInputStream produkt13a = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\untitled4\\src\\sample\\p12.png");
        Image prod13a = new Image(produkt13a);
        ImageView pro13a = new ImageView(prod13a);
        pro13a.setImage(prod13a);
        FileInputStream produkt14a = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\untitled4\\src\\sample\\p13.png");
        Image prod14a = new Image(produkt14a);
        ImageView pro14a = new ImageView(prod14a);
        pro14a.setImage(prod14a);
        FileInputStream produkt15a = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\untitled4\\src\\sample\\p14.png");
        Image prod15a = new Image(produkt15a);
        ImageView pro15a = new ImageView(prod15a);
        pro15a.setImage(prod15a);

        FileInputStream produkt1 = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\untitled4\\src\\sample\\p0.png");
        Image prod1 = new Image(produkt1);
        ImageView pro1 = new ImageView(prod1);
        pro1.setImage(prod1);
        FileInputStream produkt2 = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\untitled4\\src\\sample\\p1.png");
        Image prod2 = new Image(produkt2);
        ImageView pro2 = new ImageView(prod2);
        pro2.setImage(prod2);
        FileInputStream produkt3 = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\untitled4\\src\\sample\\p2.png");
        Image prod3 = new Image(produkt3);
        ImageView pro3 = new ImageView(prod3);
        pro3.setImage(prod3);
        FileInputStream produkt4 = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\untitled4\\src\\sample\\p3.png");
        Image prod4 = new Image(produkt4);
        ImageView pro4 = new ImageView(prod4);
        pro4.setImage(prod4);
        FileInputStream produkt5 = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\untitled4\\src\\sample\\p4.png");
        Image prod5 = new Image(produkt5);
        ImageView pro5 = new ImageView(prod5);
        pro5.setImage(prod5);
        FileInputStream produkt6 = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\untitled4\\src\\sample\\p5.png");
        Image prod6 = new Image(produkt6);
        ImageView pro6 = new ImageView(prod6);
        pro6.setImage(prod6);
        FileInputStream produkt7 = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\untitled4\\src\\sample\\p6.png");
        Image prod7 = new Image(produkt7);
        ImageView pro7 = new ImageView(prod7);
        pro7.setImage(prod7);
        FileInputStream produkt8 = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\untitled4\\src\\sample\\p7.png");
        Image prod8 = new Image(produkt8);
        ImageView pro8 = new ImageView(prod8);
        pro8.setImage(prod8);
        FileInputStream produkt9 = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\untitled4\\src\\sample\\p8.png");
        Image prod9 = new Image(produkt9);
        ImageView pro9 = new ImageView(prod9);
        pro9.setImage(prod9);
        FileInputStream produkt10 = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\untitled4\\src\\sample\\p9.png");
        Image prod10 = new Image(produkt10);
        ImageView pro10 = new ImageView(prod10);
        pro10.setImage(prod10);
        FileInputStream produkt11 = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\untitled4\\src\\sample\\p10.png");
        Image prod11 = new Image(produkt11);
        ImageView pro11 = new ImageView(prod11);
        pro11.setImage(prod11);
        FileInputStream produkt12 = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\untitled4\\src\\sample\\p11.png");
        Image prod12 = new Image(produkt12);
        ImageView pro12 = new ImageView(prod12);
        pro12.setImage(prod12);
        FileInputStream produkt13 = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\untitled4\\src\\sample\\p12.png");
        Image prod13 = new Image(produkt13);
        ImageView pro13 = new ImageView(prod13);
        pro13.setImage(prod13);
        FileInputStream produkt14 = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\untitled4\\src\\sample\\p13.png");
        Image prod14 = new Image(produkt14);
        ImageView pro14 = new ImageView(prod14);
        pro14.setImage(prod14);
        FileInputStream produkt15 = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\untitled4\\src\\sample\\p14.png");
        Image prod15 = new Image(produkt15);
        ImageView pro15 = new ImageView(prod15);
        pro15.setImage(prod15);



        Button dodaj1 = new Button();
        dodaj1.setId("dodaj");
        dodaj1.setMinSize(30, 30);
        dodaj1.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());
        dodaj1.setOnAction(Dane->{lista2.get(0).i++;});
        Button dodaj2 = new Button();
        dodaj2.setId("dodaj");
        dodaj2.setMinSize(30, 30);
        dodaj2.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());
        dodaj2.setOnAction(Dane->{lista2.get(1).i++;});
        Button dodaj3 = new Button();
        dodaj3.setId("dodaj");
        dodaj3.setMinSize(30, 30);
        dodaj3.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());
        dodaj3.setOnAction(Dane->{lista2.get(2).i++;});
        Button dodaj4 = new Button();
        dodaj4.setId("dodaj");
        dodaj4.setMinSize(30, 30);
        dodaj4.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());
        dodaj4.setOnAction(Dane->{lista2.get(3).i++;});
        Button dodaj5 = new Button();
        dodaj5.setId("dodaj");
        dodaj5.setMinSize(30, 30);
        dodaj5.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());
        dodaj5.setOnAction(Dane->{lista2.get(4).i++;});
        Button dodaj6 = new Button();
        dodaj6.setId("dodaj");
        dodaj6.setMinSize(30, 30);
        dodaj6.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());
        dodaj6.setOnAction(Dane->{lista2.get(5).i++;});
        Button dodaj7 = new Button();
        dodaj7.setId("dodaj");
        dodaj7.setMinSize(30, 30);
        dodaj7.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());
        dodaj7.setOnAction(Dane->{lista2.get(6).i++;});
        Button dodaj8 = new Button();
        dodaj8.setId("dodaj");
        dodaj8.setMinSize(30, 30);
        dodaj8.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());
        dodaj8.setOnAction(Dane->{lista2.get(7).i++;});
        Button dodaj9 = new Button();
        dodaj9.setId("dodaj");
        dodaj9.setMinSize(30, 30);
        dodaj9.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());
        dodaj9.setOnAction(Dane->{lista2.get(8).i++;});
        Button dodaj10 = new Button();
        dodaj10.setId("dodaj");
        dodaj10.setMinSize(30, 30);
        dodaj10.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());
        dodaj10.setOnAction(Dane->{lista2.get(9).i++;});
        Button dodaj11 = new Button();
        dodaj11.setId("dodaj");
        dodaj11.setMinSize(30, 30);
        dodaj11.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());
        dodaj11.setOnAction(Dane->{lista2.get(10).i++;});
        Button dodaj12 = new Button();
        dodaj12.setId("dodaj");
        dodaj12.setMinSize(30, 30);
        dodaj12.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());
        dodaj12.setOnAction(Dane->{lista2.get(11).i++;});
        Button dodaj13 = new Button();
        dodaj13.setId("dodaj");
        dodaj13.setMinSize(30, 30);
        dodaj13.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());
        dodaj13.setOnAction(Dane->{lista2.get(12).i++;});
        Button dodaj14 = new Button();
        dodaj14.setId("dodaj");
        dodaj14.setMinSize(30, 30);
        dodaj14.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());
        dodaj14.setOnAction(Dane->{lista2.get(13).i++;});
        Button dodaj15 = new Button();
        dodaj15.setId("dodaj");
        dodaj15.setMinSize(30, 30);
        dodaj15.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());
        dodaj15.setOnAction(Dane->{lista2.get(14).i++;});

        Button usun1 = new Button();
        usun1.setId("usun");
        usun1.setMinSize(30, 30);
        usun1.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());
        usun1.setOnAction(Dane->{if(lista2.get(0).i>0){lista2.get(0).i--;}});
        Button usun2 = new Button();
        usun2.setId("usun");
        usun2.setMinSize(30, 30);
        usun2.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());
        usun2.setOnAction(Dane->{if(lista2.get(1).i>0){lista2.get(1).i--;}});
        Button usun3 = new Button();
        usun3.setId("usun");
        usun3.setMinSize(30, 30);
        usun3.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());
        usun3.setOnAction(Dane->{if(lista2.get(2).i>0){lista2.get(2).i--;}});
        Button usun4 = new Button();
        usun4.setId("usun");
        usun4.setMinSize(30, 30);
        usun4.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());
        usun4.setOnAction(Dane->{if(lista2.get(3).i>0){lista2.get(3).i--;}});
        Button usun5 = new Button();
        usun5.setId("usun");
        usun5.setMinSize(30, 30);
        usun5.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());
        usun5.setOnAction(Dane->{if(lista2.get(4).i>0){lista2.get(4).i--;}});
        Button usun6 = new Button();
        usun6.setId("usun");
        usun6.setMinSize(30, 30);
        usun6.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());
        usun6.setOnAction(Dane->{if(lista2.get(5).i>0){lista2.get(5).i--;}});
        Button usun7 = new Button();
        usun7.setId("usun");
        usun7.setMinSize(30, 30);
        usun7.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());
        usun7.setOnAction(Dane->{if(lista2.get(6).i>0){lista2.get(6).i--;}});
        Button usun8 = new Button();
        usun8.setId("usun");
        usun8.setMinSize(30, 30);
        usun8.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());
        usun7.setOnAction(Dane->{if(lista2.get(7).i>0){lista2.get(7).i--;}});
        Button usun9 = new Button();
        usun9.setId("usun");
        usun9.setMinSize(30, 30);
        usun9.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());
        usun9.setOnAction(Dane->{if(lista2.get(8).i>0){lista2.get(8).i--;}});
        Button usun10 = new Button();
        usun10.setId("usun");
        usun10.setMinSize(30, 30);
        usun10.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());
        usun10.setOnAction(Dane->{if(lista2.get(9).i>0){lista2.get(9).i--;}});
        Button usun11 = new Button();
        usun11.setId("usun");
        usun11.setMinSize(30, 30);
        usun11.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());
        usun11.setOnAction(Dane->{if(lista2.get(10).i>0){lista2.get(10).i--;}});
        Button usun12 = new Button();
        usun12.setId("usun");
        usun12.setMinSize(30, 30);
        usun12.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());
        usun12.setOnAction(Dane->{if(lista2.get(11).i>0){lista2.get(11).i--;}});
        Button usun13 = new Button();
        usun13.setId("usun");
        usun13.setMinSize(30, 30);
        usun13.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());
        usun13.setOnAction(Dane->{if(lista2.get(12).i>0){lista2.get(12).i--;}});
        Button usun14 = new Button();
        usun14.setId("usun");
        usun14.setMinSize(30, 30);
        usun14.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());
        usun14.setOnAction(Dane->{if(lista2.get(13).i>0){lista2.get(13).i--;}});
        Button usun15 = new Button();
        usun15.setId("usun");
        usun15.setMinSize(30, 30);
        usun15.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());
        usun15.setOnAction(Dane->{if(lista2.get(14).i>0){lista2.get(14).i--;}});


        HBox produkty1 = new HBox();
        produkty1.setId("produkty1");
        produkty1.setMinWidth(900);
        produkty1.setPrefHeight(180);
        produkty1.setSpacing(30);
        produkty1.getChildren().addAll(kategoria1);
        produkty1.setStyle("-fx-background-color:rgb(255, 255, 255);");
        produkty1.setPadding(new Insets(30, 0, 0, 0));
        produkty1.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());

        HBox guziki1 = new HBox();
        guziki1.setId("guziki");
        guziki1.setMinWidth(900);
        guziki1.setPrefHeight(30);
        guziki1.setSpacing(30);
        guziki1.setStyle("-fx-background-color:rgb(255, 255, 255);");
        guziki1.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());


        HBox produkty2 = new HBox();
        produkty2.setId("produkty2");
        produkty2.setMinWidth(900);
        produkty2.setPrefHeight(180);
        produkty2.setSpacing(30);
        produkty2.getChildren().addAll(kategoria2);
        produkty2.setStyle("-fx-background-color:rgb(255, 255, 255);");
        produkty2.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());

        HBox guziki2 = new HBox();
        guziki2.setId("guziki");
        guziki2.setMinWidth(900);
        guziki2.setPrefHeight(30);
        guziki2.setSpacing(60);
        //guziki2.getChildren().addAll(dodaj6,usun6,dodaj7,usun7,dodaj8,usun8,dodaj9,usun9,dodaj10,usun10);
        guziki2.setStyle("-fx-background-color:rgb(255, 255, 255);");
        guziki2.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());

        HBox produkty3 = new HBox();
        produkty3.setId("produkty3");
        produkty3.setMinWidth(900);
        produkty3.setPrefHeight(180);
        produkty3.setSpacing(30);
        produkty3.getChildren().addAll(kategoria3);
        produkty3.setStyle("-fx-background-color:rgb(255, 255, 255);");
        produkty3.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());

        HBox guziki3 = new HBox();
        guziki3.setId("guziki");
        guziki3.setMinWidth(900);
        guziki3.setPrefHeight(30);
        guziki3.setSpacing(60);
        //guziki3.getChildren().addAll(dodaj11,usun11,dodaj12,usun12,dodaj13,usun13,dodaj14,usun14,dodaj15,usun15);
        guziki3.setStyle("-fx-background-color:rgb(255, 255, 255);");
        guziki3.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());

        VBox pasek_lewy = new VBox();
        pasek_lewy.setSpacing(80);
        pasek_lewy.setMinWidth(100);
        pasek_lewy.setPrefHeight(500);
        pasek_lewy.setStyle("-fx-background-color:rgb(255, 255, 255);");
        pasek_lewy.getStylesheets().addAll(this.getClass().getResource("styl.css").toExternalForm());
        okno.add(pasek_lewy, 0, 3, 1, 6);


        VBox pasek_prawy = new VBox();
        pasek_prawy.setMinWidth(100);
        pasek_prawy.setPrefHeight(500);
        pasek_prawy.setStyle("-fx-background-color:rgb(255, 255, 255);");
        okno.add(pasek_prawy, 2, 3, 1, 6);


        okno.add(produkty1, 1, 3, 1, 1);
        okno.add(guziki1, 1, 4, 1, 1);
        okno.add(produkty2, 1, 5, 1, 1);
        okno.add(guziki2, 1, 6, 1, 1);
        okno.add(produkty3, 1, 7, 1, 1);
        okno.add(guziki3, 1, 8, 1, 1);


        kategoria1.setOnAction(klik -> {
            produkty1.getChildren().remove(kategoria1);
            produkty2.getChildren().remove(kategoria2);
            produkty3.getChildren().remove(kategoria3);
            produkty2.getChildren().removeAll(labelki.get(5), labelki.get(6), labelki.get(7), labelki.get(8), labelki.get(9));
            produkty3.getChildren().removeAll(labelki.get(10), labelki.get(11), labelki.get(12), labelki.get(13), labelki.get(14));
            produkty1.getChildren().removeAll(labelki.get(0), labelki.get(1), labelki.get(2), labelki.get(3), labelki.get(4));
            produkty2.getChildren().addAll(pro1, pro2, pro3, pro4, pro5);

        });
        kategoria2.setOnAction(klik -> {
            produkty1.getChildren().removeAll(kategoria1);
            produkty1.getChildren().removeAll(labelki.get(0), labelki.get(1), labelki.get(2), labelki.get(3), labelki.get(4));
            produkty2.getChildren().remove(kategoria2);
            produkty3.getChildren().remove(kategoria3);
            produkty2.getChildren().removeAll(labelki.get(5), labelki.get(6), labelki.get(7), labelki.get(8), labelki.get(9));
            produkty3.getChildren().removeAll(labelki.get(10), labelki.get(11), labelki.get(12), labelki.get(13), labelki.get(14));
            produkty2.getChildren().addAll(pro6, pro7, pro8, pro9, pro10);

        });

        kategoria3.setOnAction(klik -> {
            produkty1.getChildren().removeAll(kategoria1);
            produkty1.getChildren().removeAll(labelki.get(0), labelki.get(1), labelki.get(2), labelki.get(3), labelki.get(4));
            produkty2.getChildren().removeAll(labelki.get(0), labelki.get(1), labelki.get(2), labelki.get(3), labelki.get(4));
            produkty2.getChildren().remove(kategoria2);
            produkty3.getChildren().remove(kategoria3);
            produkty2.getChildren().removeAll(labelki.get(5), labelki.get(6), labelki.get(7), labelki.get(8), labelki.get(9));
            produkty3.getChildren().removeAll(labelki.get(10), labelki.get(11), labelki.get(12), labelki.get(13), labelki.get(14));
            produkty2.getChildren().addAll(pro11,pro12,pro13,pro14,pro15);


        });


        kategorie.setOnAction(Dane -> {
            produkty1.getChildren().removeAll(labelki.get(0), labelki.get(1), labelki.get(2), labelki.get(3), labelki.get(4));
            produkty2.getChildren().removeAll(labelki.get(0), labelki.get(1), labelki.get(2), labelki.get(3), labelki.get(4), labelki.get(5), labelki.get(6), labelki.get(7), labelki.get(8), labelki.get(9), labelki.get(10), labelki.get(11), labelki.get(12), labelki.get(13), labelki.get(14));
            produkty3.getChildren().removeAll(labelki.get(10), labelki.get(11), labelki.get(12), labelki.get(13), labelki.get(14));
            guziki1.getChildren().removeAll(dodaj1, usun1, dodaj2, usun2, dodaj3, usun3, dodaj4, usun4, dodaj5, usun5);
            guziki2.getChildren().removeAll(dodaj6, usun6, dodaj7, usun7, dodaj8, usun8, dodaj9, usun9, dodaj10, usun10);
            guziki3.getChildren().removeAll(dodaj11, usun11, dodaj12, usun12, dodaj13, usun13, dodaj14, usun14, dodaj15, usun15);
            produkty2.getChildren().removeAll(pro1, pro2, pro3, pro4, pro5);
            produkty2.getChildren().removeAll(pro6, pro7, pro8, pro9, pro10);
            produkty2.getChildren().removeAll(pro11,pro12,pro13,pro14,pro15);
            produkty1.getChildren().addAll(kategoria1);
            produkty2.getChildren().addAll(kategoria2);
            produkty3.getChildren().addAll(kategoria3);
            produkty1.getChildren().removeAll(pro1a,pro2a,pro3a,pro4a,pro5a);
            produkty2.getChildren().removeAll(pro6a, pro7a, pro8a, pro9a, pro10a);
            produkty3.getChildren().removeAll(pro11a,pro12a,pro13a,pro14a,pro15a);

            guziki1.getChildren().removeAll(lista2.get(0).lal,lista2.get(1).lal,lista2.get(2).lal,lista2.get(3).lal,lista2.get(4).lal);
            guziki2.getChildren().removeAll(lista2.get(5).lal,lista2.get(6).lal,lista2.get(7).lal,lista2.get(8).lal,lista2.get(9).lal);
            guziki3.getChildren().removeAll(lista2.get(10).lal,lista2.get(11).lal,lista2.get(12).lal,lista2.get(13).lal,lista2.get(14).lal);

        });

        wszystkie.setOnAction(Dane -> {
                    produkty1.getChildren().remove(kategoria1);
                    produkty2.getChildren().remove(kategoria2);
                    produkty3.getChildren().remove(kategoria3);

                    produkty2.getChildren().removeAll(pro1, pro2, pro3, pro4, pro5);
                    produkty2.getChildren().removeAll(pro6, pro7, pro8, pro9, pro10);
                    produkty2.getChildren().removeAll(pro11,pro12,pro13,pro14,pro15);

                    produkty1.getChildren().addAll(labelki.get(0), labelki.get(1), labelki.get(2), labelki.get(3), labelki.get(4));
                    produkty2.getChildren().addAll(labelki.get(5), labelki.get(6), labelki.get(7), labelki.get(8), labelki.get(9));
                    produkty3.getChildren().addAll(labelki.get(10), labelki.get(11), labelki.get(12), labelki.get(13), labelki.get(14));

                    guziki1.getChildren().addAll(dodaj1, usun1, dodaj2, usun2, dodaj3, usun3, dodaj4, usun4, dodaj5, usun5);
                    guziki2.getChildren().addAll(dodaj6, usun6, dodaj7, usun7, dodaj8, usun8, dodaj9, usun9, dodaj10, usun10);
                    guziki3.getChildren().addAll(dodaj11, usun11, dodaj12, usun12, dodaj13, usun13, dodaj14, usun14, dodaj15, usun15);

                    produkty1.getChildren().removeAll(pro1a,pro2a,pro3a,pro4a,pro5a);
                    produkty2.getChildren().removeAll(pro6a, pro7a, pro8a, pro9a, pro10a);
                    produkty3.getChildren().removeAll(pro11a,pro12a,pro13a,pro14a,pro15a);

            guziki1.setSpacing(60);
            guziki2.setSpacing(60);
            guziki3.setSpacing(60);

            guziki1.getChildren().removeAll(lista2.get(0).lal,lista2.get(1).lal,lista2.get(2).lal,lista2.get(3).lal,lista2.get(4).lal);
            guziki2.getChildren().removeAll(lista2.get(5).lal,lista2.get(6).lal,lista2.get(7).lal,lista2.get(8).lal,lista2.get(9).lal);
            guziki3.getChildren().removeAll(lista2.get(10).lal,lista2.get(11).lal,lista2.get(12).lal,lista2.get(13).lal,lista2.get(14).lal);

                }
        );

        koszyk.setOnAction(Dane -> {

            guziki1.setSpacing(150);
            guziki2.setSpacing(150);
            guziki3.setSpacing(150);

            produkty1.getChildren().removeAll(labelki.get(0), labelki.get(1), labelki.get(2), labelki.get(3), labelki.get(4));
            produkty2.getChildren().removeAll(labelki.get(5), labelki.get(6), labelki.get(7), labelki.get(8), labelki.get(9));
            produkty3.getChildren().removeAll(labelki.get(10), labelki.get(11), labelki.get(12), labelki.get(13), labelki.get(14));

            produkty2.getChildren().removeAll(pro1, pro2, pro3, pro4, pro5);
            produkty2.getChildren().removeAll(pro6, pro7, pro8, pro9, pro10);
            produkty2.getChildren().removeAll(pro11,pro12,pro13,pro14,pro15);

            produkty1.getChildren().remove(kategoria1);
            produkty2.getChildren().remove(kategoria2);
            produkty3.getChildren().remove(kategoria3);

            produkty1.getChildren().addAll(pro1a,pro2a,pro3a,pro4a,pro5a);
            produkty2.getChildren().addAll(pro6a, pro7a, pro8a, pro9a, pro10a);
            produkty3.getChildren().addAll(pro11a,pro12a,pro13a,pro14a,pro15a);

            guziki1.getChildren().removeAll(dodaj1, usun1, dodaj2, usun2, dodaj3, usun3, dodaj4, usun4,dodaj5,usun5);
            guziki2.getChildren().removeAll(dodaj6, usun6, dodaj7, usun7, dodaj8, usun8, dodaj9, usun9, dodaj10, usun10);
            guziki3.getChildren().removeAll(dodaj11, usun11, dodaj12, usun12, dodaj13, usun13, dodaj14, usun14, dodaj15, usun15);

            guziki1.getChildren().addAll(lista2.get(0).tworz(),lista2.get(1).tworz(),lista2.get(2).tworz(),lista2.get(3).tworz(),lista2.get(4).tworz());
            guziki2.getChildren().addAll(lista2.get(5).tworz(),lista2.get(6).tworz(),lista2.get(7).tworz(),lista2.get(8).tworz(),lista2.get(9).tworz());
            guziki3.getChildren().addAll(lista2.get(10).tworz(),lista2.get(11).tworz(),lista2.get(12).tworz(),lista2.get(13).tworz(),lista2.get(14).tworz());

        });


        primaryStage.setScene(scena1);
        primaryStage.show();
    }


    public static void main(String[] args) { launch(args); }
}
