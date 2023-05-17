����   = t  pooMain/Usuario  java/lang/Object name Ljava/lang/String; username senha seriesAssistidas Ljava/util/List; 	Signature !Ljava/util/List<LpooMain/Serie;>; seriesParaAssistir getName ()Ljava/lang/String; Code	     LineNumberTable LocalVariableTable this LpooMain/Usuario; setName (Ljava/lang/String;)V getUsername	     setUsername getSenha	     setSenha getSeriesAssistidas ()Ljava/util/List; #()Ljava/util/List<LpooMain/Serie;>;	  % 	 
 setSeriesAssistidas (Ljava/util/List;)V $(Ljava/util/List<LpooMain/Serie;>;)V LocalVariableTypeTable getSeriesParaAssistir	  ,  
 setSeriesParaAssistir <init> 9(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
  1 . 2 ()V 4 java/util/ArrayList
 3 1 checarCredenciais '(Ljava/lang/String;Ljava/lang/String;)Z
 9 ; : java/lang/String < = equals (Ljava/lang/Object;)Z StackMapTable assistirSerie (LpooMain/Serie;)V B D C java/util/List E = contains B G H = add serie LpooMain/Serie;  adicionarListaSeriesParaAssistir removerListaSeriesParaAssistir B N O = remove buscarSerieAssistidaPorGenero $(Ljava/lang/String;)Ljava/util/List; 5(Ljava/lang/String;)Ljava/util/List<LpooMain/Serie;>; B T U V iterator ()Ljava/util/Iterator; X Z Y java/util/Iterator [ \ next ()Ljava/lang/Object; ^ pooMain/Serie
 ] ` a  	getGenero X c d e hasNext ()Z genero seriesFiltradas buscarSerieAssistidaPorNome nome buscarSerieAssistidaPorIdioma
 ] l m  	getIdioma idioma  buscarSerieParaAssistirPorGenero buscarSerieParaAssistirPorNome  buscarSerieParaAssistirPorIdioma 
SourceFile Usuario.java !                      	 
         
               /     *� �                               >     *+� �       
                                /     *� �                               >     *+� �       
                                 /     *� �           #                     >     *+� �       
    '  (                    ! "      #    /     *� $�           +              & '      (    P     *+� $�       
    /  0                	 
  )        	    * "      #    /     *� +�           3              - '      (    P     *+� +�       
    7  8                 
  )            . /     {     *� 0*� 3Y� 5� $*+� *,� *-� �           ;    <  =  >  ?    *                            6 7     i     +*� � 8� ,*� � 8� ��           B  C  E                          >      ? @     ^     *� $+� A � *� $+� F W�           I  J  L                I J  >      K @     ^     *� ++� A � *� ++� F W�           O  P  R                I J  >      L @     ^     *� ++� A � *� ++� M W�           U  V  X                I J  >      P Q      R    �     @� 3Y� 5M*� $� S :� !� W � ]N-� _+� 8� ,-� F W� b ���,�           [  ] ! ^ , _ 4 ] > c    *    @       @ f    8 g 
  !  I J  )      8 g   >    �    9 B  X    h Q      R    �     @� 3Y� 5M*� $� S :� !� W � ]N-� _+� 8� ,-� F W� b ���,�           g  i ! j , k 4 i > o    *    @       @ i    8 g 
  !  I J  )      8 g   >    �    9 B  X    j Q      R    �     @� 3Y� 5M*� $� S :� !� W � ]N-� k+� 8� ,-� F W� b ���,�           s  u ! v , w 4 u > {    *    @       @ n    8 g 
  !  I J  )      8 g   >    �    9 B  X    o Q      R    �     @� 3Y� 5M*� +� S :� !� W � ]N-� _+� 8� ,-� F W� b ���,�             � ! � , � 4 � > �    *    @       @ f    8 g 
  !  I J  )      8 g   >    �    9 B  X    p Q      R    �     @� 3Y� 5M*� +� S :� !� W � ]N-� _+� 8� ,-� F W� b ���,�           �  � ! � , � 4 � > �    *    @       @ i    8 g 
  !  I J  )      8 g   >    �    9 B  X    q Q      R    �     @� 3Y� 5M*� +� S :� !� W � ]N-� k+� 8� ,-� F W� b ���,�           �  � ! � , � 4 � > �    *    @       @ n    8 g 
  !  I J  )      8 g   >    �    9 B  X    r    s