/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.text.NumberFormat;
import java.util.Calendar;
import javax.imageio.ImageIO;

/**
 *
 * @author
 */
public class Utilidades {

    public static double converteCampoMoedaParaDouble(String valor) {
        valor = valor.replaceAll("[R$.]", "").replace(",", ".");

        return Double.parseDouble(valor);

    }

    public static String converteDoubleParaCampoMoeda(double valor) {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return nf.format(valor);
    }

    public static void setaIconeJFrame(JFrame form) {
        ImageIcon icone = new ImageIcon(form.getClass().getResource("/imagens/logo_pedido.png"));
        form.setIconImage(icone.getImage());
    }

    public static void criarPastaDosArquivosPDF(String caminho) {
        File f = new File(caminho);
        if (!f.isDirectory()) {
            f.mkdirs();
        }
    }

    public static String montarData(Calendar calendar) {
        String retorno = "";
        int semana = calendar.get(Calendar.DAY_OF_WEEK);

        switch (semana) {
            case 1:
                retorno += "Domingo ";
                break;
            case 2:
                retorno += "Segunda-Feira ";
                break;
            case 3:
                retorno += "Terça-Feira ";
                break;
            case 4:
                retorno += "Quarta-Feira ";
                break;
            case 5:
                retorno += "Quinta-Feira ";
                break;
            case 6:
                retorno += "Sexta-Feira ";
                break;
            case 7:
                retorno += "Sábado ";
                break;
        }

        retorno += calendar.get(Calendar.DAY_OF_MONTH);
        int mes = calendar.get(Calendar.MONTH);

        switch (mes) {
            case 0:
                retorno += " de Janeiro de ";
                break;
            case 1:
                retorno += " de Fevereiro de ";
                break;
            case 2:
                retorno += " de Março de ";
                break;
            case 3:
                retorno += " de Abril de ";
                break;
            case 4:
                retorno += " de Maio de ";
                break;
            case 5:
                retorno += " de Junho de ";
                break;
            case 6:
                retorno += " de Julho de ";
                break;
            case 7:
                retorno += " de Agosto de ";
                break;
            case 8:
                retorno += " de Setembro de ";
                break;
            case 9:
                retorno += " de Outubro de ";
                break;
            case 10:
                retorno += " de Novembro de ";
                break;
            case 11:
                retorno += " de Dezembro de ";
                break;
        }

        retorno += calendar.get(Calendar.YEAR);
        return retorno;
    }

    public static Image redimensionarImagemComCaminho(String caminho, int width, int height) {//Redimensionar imagem.

        BufferedImage fundo = null;
        try {
            fundo = ImageIO.read(new File(caminho));

        } catch (IOException e1) {
            fundo = new BufferedImage(1, 1, BufferedImage.BITMASK);
        }

        int alturaImagem = fundo.getHeight();
        int larguraImagem = fundo.getWidth();

        int novaAltura;
        int novaLargura;

        if (alturaImagem >= larguraImagem) {
            novaAltura = height;
            novaLargura = ((novaAltura * larguraImagem) / alturaImagem);
        } else {
            novaLargura = width;
            novaAltura = ((novaLargura * alturaImagem) / larguraImagem);

        }
        return fundo.getScaledInstance(novaLargura, novaAltura, 10000);
    }

    public static BufferedImage getImage(byte[] bytes) {

        InputStream in = new ByteArrayInputStream(bytes);
        BufferedImage img = null;

        try {
            img = ImageIO.read(in);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return img;
    }

    public static Image redimensionarImagem2(Image image, int width, int height) {//Redimensionar imagem.

        BufferedImage fundo = null;
        try {
            fundo = (BufferedImage) image;

        } catch (Exception e1) {
            fundo = new BufferedImage(1, 1, BufferedImage.BITMASK);
        }

        int alturaImagem = fundo.getHeight();
        int larguraImagem = fundo.getWidth();

        int novaAltura;
        int novaLargura;

        if (alturaImagem >= larguraImagem) {
            novaAltura = height;
            novaLargura = ((novaAltura * larguraImagem) / alturaImagem);
        } else {
            novaLargura = width;
            novaAltura = ((novaLargura * alturaImagem) / larguraImagem);
        }
        return fundo.getScaledInstance(novaLargura, novaAltura, 10000);
    }
     public boolean validarTelefone(String telefone){
        
        /* 
            Tem que ter de 8 à 9 digitos 
            ignorar - 
            para 9+ digitos deverá comecar 
                com 8 ou 9 (celular)
            
            Ex. de num. válidos  
                3222-8888
                33332222
                99998888
        
        */
        // Remove os tracos
        String telefoneAux = telefone.replace("-", "");
        
        // Se valor informado eh um numero inteiro
        try{
            Integer.parseInt(telefoneAux);
        }catch(NumberFormatException e){
            return false;
        }
        
        // Verifica celular
        if(telefoneAux.length() == 9){
            if(!(telefoneAux.substring(0, 1).equals("8") ||
               telefoneAux.substring(0, 1).equals("9"))){
                return false;
            }
            
            
        }else{
            // Telefone residencial/comercial
            if(telefoneAux.length() != 8){
                return false;
            }
             
        }
        return true;
    }

}
