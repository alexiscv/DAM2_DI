   M S B A M L   `   `   `  ����!  DAM2_DI_U5_WPF_EJ04_AppLibros0    *DAM2_DI_U5_WPF_EJ04_AppLibros.DialogoLibro   5   	   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	     � Title$  DialogoLibro��5   	   $	��214��6   $	��357��6+   .��5      � .+�5   
   �� $��Titulo��6   $
��Left=�6!   $��	71,18,0,0q�6<   $	��Top=�6O   �� 5   
   $��Autor��6   $
��Left=�6    $��	71,60,0,0q�6;   $	��Top=�6N   �� 5   
   $��Fecha de entrada��6   $
��Left=�6+   $��
10,103,0,0q�6F   $	��Top=�6Z   �� 5	   
   -   5         ��Name$ textBoxTitulo��5	      $��23��6)   $��120,21,10,0q�65    �� TextWrapping$
 Wrap=�6J   $	��Top=�6^   ��6v   ��  �� Path$ Titulo� �� NotifyOnValidationError .  �� ValidatesOnDataErrors . 6�   �� 5
   
   -   5        $ textBoxAutor��5
      $��23��6(   $��120,64,10,0q�64   $
 Wrap=�6I   $	��Top=�6]   ��6u   �� $ Autor� .  . 6�   (  "System.Windows.Controls.DatePicker  5   
   -   5          Name$ datePickerFecha��5      $��120,105,10,0q�6.   $	��Top=�6D      FirstDayOfWeek$ Monday=�6\      SelectedDate 6t   �� $ FechaEntrada��� 5   
   -   5        	 ��Name$	 botonAceptar��5      $��Aceptar��6'   $
��Left=�69   $��
10,144,0,0q�6T   $	��Top=�6h   $	��249��6�   6�   �� 5   
   -   5        $	 botonCancelar��5      $��Cancelar��6(   $��264,144,10,0q�6;   $	��Top=�6Q   6i   5      5      