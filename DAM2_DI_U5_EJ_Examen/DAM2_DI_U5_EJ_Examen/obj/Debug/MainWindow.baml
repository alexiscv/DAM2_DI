   M S B A M L   `   `   `  ����  DAM2_DI_U5_EJ_Examen%    DAM2_DI_U5_EJ_Examen.MainWindow   5   	   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	     � Title$  
MainWindow��5   	   $	��350��6   $	��432��6)   .��5      � .+�5   
   �� $	��319��6   $	��Top=�6   $��
Desert.jpg��65   $
��Left=�6I   $	��424��6d   �� 5   
   $!��Registro entradas y salidas��6   $��
0,25,120,0q�66   $	��Top=�6J   $��22(�6b   $��Center=�6p   $	��274��6�   &   System.Windows.Controls.DataGrid  5   
   -   5          Name$ DataGridPersonas��5         AutoGenerateColumns .  $
��Left=�6t   $��	10,69,0,0q�6�   $	��Top=�6�   $	��189��6�   $	��403��6�   ��6I   ��  �� Path$ listaPersonas�   Columns 5	      0  *System.Windows.Controls.DataGridTextColumn  5
      ,  &System.Windows.Controls.DataGridColumn   Header$ Nombre��6E   1  +System.Windows.Controls.DataGridBoundColumn   Binding 6%   �� $ Nombre�6E     5      $ 	Apellidos��6H    6%   �� $ 	Apellidos�6H     5      $ Estado��6E    6%   �� $ Estado�6E   5      �� 5   
   -   5         ��Name$ ComboBoxPersonas��5      $
��Left=�6-   $��
10,263,0,0q�6H   $	��Top=�6\   $	��237��6t   ��5      �� $ listaPersonas� �� SelectedItem 5      �� $ personaSeleccionada��� 5   
   -   5        	 ��Name$	 botonEntrar��5      $��Entrar��6&   $
��Left=�67   $��258,265,0,0q�6R   $	��Top=�6g   $��75��6   {�6�   �� $ personaSeleccionada.Fuera�6�   �� 5   
   -   5        $	 
botonSalir��5      $��Salir��6%   $
��Left=�65   $��338,265,0,0q�6P   $	��Top=�6e   $��75��6}   {�6�   �� $  personaSeleccionada.Dentro�6�   o� 5   
   $
��Left=�6   $��25��6*   $	��Top=�66   $	��424��6N   .@�5      m� $��Personas��6   $��97��6)   $��25��64   .@�5      m� -   5        $��Nueva...��5      $��25��6-   $	��200��69   6a   5      5      5      5      