package sample;

import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Examen {
    public List<Boolean> question1() {
        /*
        Pondération: 10/70 (~15%) (~25 minutes)
        Pour réussir cette question, vous devez retourner le résultat d'un appel à Collider.getColliderList().
        Collider.getColliderList() prend un seul paramètre, une expression lambda, qui prend elle même deux paramètres:
        un Point et un Cercle. Référez-vous à ces classes pour connaître leur structure.
        Votre expression lambda doit déterminer s'il y a collision entre le point et le cercle qui lui sont passés
        en paramètres.

        Pour trouver s'il y a collision, utilisez pythagore pour calculer la distance entre le centre du cercle et
        le point, et comparez-la avec le rayon du cercle.
         */

        return null;

    }

    public String question2(List<String> contenu) {
        /*
        Pondération: 10/70 (~15%) (~25 minutes)
        Pour réussir cette question, vous devez utiliser les streams sur la liste passée en paramètre
        pour réaliser les actions suivantes:
         - Ne garder que les String commençant par "password:"
         - Extraire ce qui suit "password:"
         - Retourner une chaîne avec un mot de passe par ligne
         */


        List<String> toList=contenu.stream()
                .filter((n)->n.contains("password:"))
                .map((n)->n.substring(n.indexOf(':')).substring(1))
                .collect(Collectors.toList());
        String answer=toList.stream()
                .reduce((acc,nouveau)->acc+nouveau)
                .get();



        return answer;
    }

    public List<Integer> question3() {
        /*
        Pondération: 10/70 (~15%) (~25 minutes)
        Pour réussir cette question, vous devez utiliser un Infinite Stream pour trouver les 10 premiers carrés
        parfaits pairs.
        Pour rappel, un carré parfait est un entier dont la racine carrée est aussi un entier.
        Exemple: sqrt(25) == 5, 25 est donc un carré parfait
         */
        List<Integer> liste=IntStream.iterate(1,(n)->n+1)
                .map((n)->n*n)
                .limit(10)
                .boxed()
                .collect(Collectors.toList());
        return liste;
    }

    public void question4(Stage stage) {
        /*
        Pondération: 15/70 (~20%) (~30 minutes)
        Pour réussir cette question, vous devez simuler le lancer d'un dé à 20 faces.
        Le Stage vous est fourni en paramètre. Vous devez afficher un Label et un Button.
        Lors du clic sur le bouton, le label doit afficher un nombre au hasard entre 1 et 20.
        Le Stage vous est passé tel quel et aucune modification n'a été apportée.
         */
        final int[] nb = {0};
        stage.setWidth(200);
        stage.setHeight(200);
        stage.setTitle("dé 20 faces");
        Label pts= new Label("resultat : "+ nb[0]);
        Button clicker= new Button("ROLL");
        clicker.setTranslateX(100);
        clicker.setTranslateY(100);
        pts.setScaleX(2);
        pts.setScaleY(2);
        pts.setTranslateX(50);
        pts.setTranslateY(30);
        clicker.setPrefSize(50,50);
        clicker.setOnAction((event) ->{
            nb[0]=(int)(Math.random()*(20)+1);
            pts.setText("resultat : "+nb[0]);
        });

        Group root=new Group(clicker,pts);
        stage.setScene(
                new Scene(root)
        );
        stage.show();

    }

    public void question5(Stage stage) {
        /*
        Pondération: 25/70 (~35%) (~60 minutes)
        Pour réussir cette question, vous devez recréer le dessin que vous trouverez dans le fichier
        "question5_resultat.gif" dans le Stage qui vous est fourni en paramètre.
        Voici une liste des couleurs utilisées:
         - BLACK
         - GREY
         - DARKRED
         - DARKCYAN
         - DARKBLUE
         - DARKGREEN
         - DARKORANGE
         - DARKMAGENTA
         - DARKOLIVEGREEN
         */
        stage.setWidth(400);
        stage.setHeight(400);
        stage.setTitle("Gif");
        Rectangle trainBlue=new Rectangle(180,150,150,70);
        Rectangle trainRed=new Rectangle(80,80,100,140);
        Rectangle trainBlack=new Rectangle(80,220,250,50);
        trainBlue.setFill(Color.DARKBLUE);
        trainRed.setFill(Color.DARKRED);
        Polygon trainDevant=new Polygon(330,220,380,280,330,280);
        trainDevant.setFill(Color.DARKMAGENTA);
        Rectangle window=new Rectangle(95,95,70,30);

        Stop[] stops=new Stop[]{
                new Stop(0,Color.WHITE),
                new Stop(1,Color.DARKCYAN)
        };
        LinearGradient grad=new LinearGradient(0,0,1,1,
                true,CycleMethod.NO_CYCLE,stops);
        window.setFill(grad);
        Arc trainTop = new Arc(330,185,30,35,-90, 180);
        trainTop.setType(ArcType.OPEN);
        trainTop.setFill(Color.DARKOLIVEGREEN);
        Rectangle chemine=new Rectangle(255,110,20,40);
        chemine.setFill(Color.DARKGREEN);
        Polygon chemineTop=new Polygon(255,110,275,110,285,95,245,95);
        chemineTop.setFill(Color.DARKORANGE);


        trainBlack.setEffect(new DropShadow(25,-15,15,Color.BLACK));
        trainRed.setEffect(new DropShadow(25,-15,15,Color.BLACK));
        trainDevant.setEffect(new DropShadow(25,-15,15,Color.BLACK));
        chemine.setEffect(new DropShadow(25,-15,15,Color.BLACK));
        chemineTop.setEffect(new DropShadow(25,-15,15,Color.BLACK));




        Arc roue1 = new Arc(120,270,20,20,0, 360);
        roue1.setType(ArcType.OPEN);
        roue1.setStroke(Color.GREY);
        roue1.setStrokeWidth(5);
        roue1.setFill(Color.TRANSPARENT);
        Arc roue2 = new Arc(180,270,20,20,0, 360);
        roue2.setType(ArcType.OPEN);
        roue2.setStroke(Color.GREY);
        roue2.setStrokeWidth(5);
        roue2.setFill(Color.TRANSPARENT);
        Arc roue3 = new Arc(240,270,20,20,0, 360);
        roue3.setType(ArcType.OPEN);
        roue3.setStroke(Color.GREY);
        roue3.setStrokeWidth(5);
        roue3.setFill(Color.TRANSPARENT);
        Arc roue4 = new Arc(300,270,20,20,0, 360);
        roue4.setType(ArcType.OPEN);
        roue4.setStroke(Color.GREY);
        roue4.setStrokeWidth(5);
        roue4.setFill(Color.TRANSPARENT);
        TranslateTransition trans = new TranslateTransition(
                Duration.millis(200), roue1);
        trans.setByX(0);
        trans.setByY(-5);
        trans.setCycleCount(Timeline.INDEFINITE);
        trans.setAutoReverse(true);
        trans.play();
        TranslateTransition trans2 = new TranslateTransition(
                Duration.millis(200), roue2);
        trans2.setByX(0);
        trans2.setByY(-5);
        trans2.setCycleCount(Timeline.INDEFINITE);
        trans2.setAutoReverse(true);
        trans2.play();
        TranslateTransition trans3 = new TranslateTransition(
                Duration.millis(200), roue3);
        trans3.setByX(0);
        trans3.setByY(-5);
        trans3.setCycleCount(Timeline.INDEFINITE);
        trans3.setAutoReverse(true);
        trans3.play();
        TranslateTransition trans4 = new TranslateTransition(
                Duration.millis(200), roue4);
        trans4.setByX(0);
        trans4.setByY(-5);
        trans4.setCycleCount(Timeline.INDEFINITE);
        trans4.setAutoReverse(true);
        trans4.play();

        roue1.setEffect(new DropShadow(25,-15,15,Color.BLACK));
        roue2.setEffect(new DropShadow(25,-15,15,Color.BLACK));
        roue3.setEffect(new DropShadow(25,-15,15,Color.BLACK));
        roue4.setEffect(new DropShadow(25,-15,15,Color.BLACK));


        Line line1=new Line(5,170,45,170);
        Line line2=new Line(5,200,45,200);
        Line line3=new Line(5,230,45,230);
        RotateTransition trans7 = new RotateTransition(
                Duration.millis(300), line1);
        trans7.setByAngle(10);
        trans7.setCycleCount(Timeline.INDEFINITE);
        trans7.setAutoReverse(true);
        trans7.play();
        RotateTransition trans8 = new RotateTransition(
                Duration.millis(300), line2);
        trans8.setByAngle(10);
        trans8.setCycleCount(Timeline.INDEFINITE);
        trans8.setAutoReverse(true);
        trans8.play();
        RotateTransition trans9 = new RotateTransition(
                Duration.millis(300), line3);
        trans9.setByAngle(10);
        trans9.setCycleCount(Timeline.INDEFINITE);
        trans9.setAutoReverse(true);
        trans9.play();





        Ellipse nuage1=new Ellipse(180,30,50,20);
        Ellipse nuage2=new Ellipse(230,70,25,13);
        nuage1.setFill(Color.GREY);
        nuage2.setFill(Color.GREY);

        ScaleTransition trans5 = new ScaleTransition(
                Duration.seconds(1), nuage1);
        trans5.setByX(0.5);
        trans5.setByY(0.5);
        trans5.setCycleCount(Timeline.INDEFINITE);
        trans5.setAutoReverse(true);
        trans5.play();
        ScaleTransition trans6 = new ScaleTransition(
                Duration.seconds(1), nuage2);
        trans6.setByX(-0.2);
        trans6.setByY(-0.2);
        trans6.setCycleCount(Timeline.INDEFINITE);
        trans6.setAutoReverse(true);
        trans6.play();



        Group root=new Group(trainRed,trainDevant,window,
                trainTop,chemineTop,chemine,trainBlack,roue1,roue2,roue3,roue4,
                line1,line2,line3,nuage1,nuage2,trainBlue);
        stage.setScene(
                new Scene(root)
        );
        stage.show();

    }
}