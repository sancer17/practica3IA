###Práctica 3: Pŕactica de aprendizaje automático###

##*Problema elegido*## 

Hemos elegido el problema de predictor de partidos de tenis porque consideramos la base de datos proporcionada rica e interesante para aplicar algoritmos de apredinzaje automático. De tal manera que, dados ciertos parámetros del partido permita predecir el ganador.

##*Base de datos identificada*##

Como hemos comentado previamente, la base de datos seleccionada ha sido la obtenida del repositorio proporcionado (https://github.com/JeffSackmann/tennis_atp). Dicha base de datos contiene los datos históricos de todos los partidos de tenis de los últimos cuarenta años. En nuestro caso, hemos usado los datos relativos a la temporada 2018. 

##*Características identificadas como relevantes de los hechos*##

Las características han sido elegidas buscando el mayor rendimiento medido mediante el Weka para poder refinar el modelo predictivo. Se han descartado datos que no aportaban como nombre de los jugadores, nacionalidad, etc. porque dichos datos no arrojan valor para una predicción individual. En su lugar, nos quedamos con datos como cantidad de aces, saques que entran, break points salvados, edad, altura o ranking, entre otros datos.

##*Fichero arff obtenido*##

El fichero .arff ha sido obtenido a partir de los ficheros .csv del repositorio configurados de manera que las características del ganador y perdedor se junten (por ejemplo: winner_hand y loser_hand se convierten en p1_hand y p2_hand) y se añade un atributo **WINNER** donde se señala al ganador. Aquí es donde se hace el archiconocido *swap* de columnas. 

##*Evaluación de los resultados obtenidos*## 

Tras analizar varios algoritmos, hemos seleccionado el **Random Forest** por ser el que mejor datos arrojaba. Se adjunta en un fichero de texto dichos resultados, en los cuales se advierten las pruebs con varios años y convarios algoritmos. Se llama **resultados.txt**.

##*Generación del objeto persistene*##

Se adjunta el código para poder implementar la aplicación que dará como ganador a un jugador en función de unos atributos y datos seleccionados en el fichero *test.arff* que se cargaran en el modelo. Este código está en el fichero **serializacionUsoModeloWekaFINAL**. 

Para poder compilarlo se introduce el siguiente comando:

```

make

```

Y para ejecutar el archivo resultante:

```

java -jar aplicacion.jar

```

##*Implementación de un prototipo*##

Se adjunta el código java que hemos intentado escribir usando NetBeans. Hemos tenido un problema y es que no conseguimos compilarlo porque la libreria Weka nos dice que no contiene ciertos métodos que nos hacen falta. 
El estado en el que estamos es el siguiente: tenemos la interfaz programada y la estructura del programa y nos falta solamente ser capaces de compilarlo y pulir redirecciones de recursos. La idea era que el primer botón cargara el objeto serializado como hacemos desde consola en el apartado anterior y el segundo botón modificaría el archivo de test para meter los valores introducidos por la interfaz y como resultado ejecuta el código y nos dice el ganador.
