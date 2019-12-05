/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.classifiers.Classifier;
import weka.classifiers.trees.RandomForest;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;
import weka.core.SerializationHelper.*;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author mariano, javier y alejandro
 */
public class Modelo {
    public static void aprenderModelo()
    {
        try {
            // create J48
            Classifier cls = new RandomForest();
            
            // train
            Instances inst = new Instances(
                    new BufferedReader(
                            new FileReader("/training_data/csvPartidos.arff")));
            inst.setClassIndex(inst.numAttributes() - 1);
            cls.buildClassifier(inst);
            
            // serialize model
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream("/models/objetoRandomForest.model"));
            oos.writeObject(cls);
            oos.flush();
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static String aplicarModelo() {
        try {
            String[] valoresAtributos = {"P1", "P2"};
            Classifier clasificador  = (Classifier) weka.core.SerializationHelper.read("./models/objetoRandomForest.model");
            ConverterUtils.DataSource source = new ConverterUtils.DataSource("./test_data/testTenis.arff");
            Instances data = source.getDataSet();
            data.setClassIndex(27);
            return valoresAtributos[(int) clasificador.classifyInstance(data.instance(0))];
        } catch (Exception ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
}
