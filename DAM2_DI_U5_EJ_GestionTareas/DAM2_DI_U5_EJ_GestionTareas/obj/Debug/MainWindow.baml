   M S B A M L   `   `   `  ����  DAM2_DI_U5_EJ_GestionTareas,    &DAM2_DI_U5_EJ_GestionTareas.MainWindow   5   	   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	     � Title$  
MainWindow��5   	   $	��428��6   $	��525��6)    � Icon$ imgs/favicon.png��65   ��5      �� 5   
    �� ImageSource$ imgs/fondo.png��6   .��5
      � $��0,0,0,18q�6   .+�5   
   &   System.Windows.Controls.DataGrid  -   5          Name$ DataGridTareas��5   X      AutoGenerateColumns .  $��40,70,40,40q�6p   $	��Top=�6�   $	��253��6�   ��6   ��  �� Path$ listaTareas�   Columns 5      0  *System.Windows.Controls.DataGridTextColumn  5      -   5        	colNombre��,  &System.Windows.Controls.DataGridColumn   Header$ TAREA��5   8      
IsReadOnly . 1  +System.Windows.Controls.DataGridBoundColumn	   Binding	 6G   �� $ Nombre�6g     5      -   5        colFecha��$ 	FECHA FIN��5   7    . 	 6J   �� $ FechaLimite�
 �� StringFormat$
 
dd-MM-yyyy��6�   4  .System.Windows.Controls.DataGridCheckBoxColumn  5      -   5        colFinalizada��$ 
FINALIZADA��5   @   	 6T   �� $ 
Finalizada� �� UpdateSourceTrigger$ PropertyChanged=�   RowStyle 5      �� 5       �� 
TargetType)  #System.Windows.Controls.DataGridRow"  6    �� Triggers 5      �� 5       �� Binding 6&   �� $ Proxima� �� Value True6G   .a�5      ��  �� Property � �� �� Value
 �  ��6I   5      �� 5       6&   �� $ 
Finalizada� True6J   .a�5      ��  � ��
 � � �6K   5      5!      5$      �� 5%   
   -   5         ��Name$ 
botonNuevo��5%      $��Nuevo��6%   $��
0,349,40,0q�65   $��20��6I   $	��Top=�6U   $��Right=�6m   $��75��6�   6�   �� 5&   
   -   5        $ botonModificar��5&      $��	Modificar��6)   $��0,349,144,0q�6=   $	��Top=�6R   $��Right=�6�   $��75��6�   o� 5'   
   $��21��6   $	��Top=�6   .@�5(      m� $��Tarea��6   .@�5)      m� -   5        $��Nueva..��5)      $��21��6,   $	��300��68   6D   5*      5+      5-      5.      