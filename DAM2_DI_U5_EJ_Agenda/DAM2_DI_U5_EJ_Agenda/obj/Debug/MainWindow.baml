   M S B A M L   `   `   `  ����  DAM2_DI_U5_EJ_Agenda%    DAM2_DI_U5_EJ_Agenda.MainWindow   5   	   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	     � Title$  
MainWindow��5   	   $	��350��6   $	��525��6)   .��5      � .+�5   
   &   System.Windows.Controls.Calendar  -   5          Name$ 
calendario��5   .      IsTodayHighlighted .  $
��Left=�6j   $��	10,10,0,0q�6�   $	��Top=�6�   &   System.Windows.Controls.DataGrid  5   
   -   5          Name$ DataGridTareas��5         AutoGenerateColumns .  $��194,10,10,0q�6�   $	��Top=�6�   $	��299��6�   ��6+   ��  �� Path$ tareasFecha�   Columns 5	      0  *System.Windows.Controls.DataGridTextColumn  5      -   5        
Nombre��,  &System.Windows.Controls.DataGridColumn   Header$ Tarea��5   5      
IsReadOnly . 1  +System.Windows.Controls.DataGridBoundColumn	   Binding	 6D   �� *Nombre+6_     5      -   5        	Texto��$ Descripción��5   4    . 	 6I   �� *Texto+6c     5      -   5        	Fecha��$ Fecha��5   4    . 	 6C   �� *Fecha+6]   5      �� 5   
   -   5        
 ��Name$
 
botonNuevo��5      $��Nueva��6%   $
��Left=�65   $��
10,183,0,0q�6P   $	��Top=�6d   $	��179��6|   6�   5      5      