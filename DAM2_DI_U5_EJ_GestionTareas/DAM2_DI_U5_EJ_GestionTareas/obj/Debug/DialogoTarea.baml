   M S B A M L   `   `   `  ����  DAM2_DI_U5_EJ_GestionTareas.    (DAM2_DI_U5_EJ_GestionTareas.DialogoTarea   5   	   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	     � Title$  DialogoTarea��5   	   $	��300��6   $	��321��6+   .��5      � .+�5   
   �� $��Tarea:��6   $
��Left=�6!   $��	24,47,0,0q�6<   $	��Top=�6O   �� 5   
   $��Fecha límite:��6   $
��Left=�6(   $��	24,78,0,0q�6C   $	��Top=�6V   �� 5   
   $��Descripción:��6   $
��Left=�6'   $��
24,146,0,0q�6B   $	��Top=�6V   �� 5	   
   $��Finalizada:��6   $
��Left=�6&   $��
24,113,0,0q�6A   $	��Top=�6U   �� 5
   
   -   5         ��Name$ TextBoxNombre��5
   �   $
��Left=�6�   $��23��6�   $��
103,50,0,0q�6�    �� TextWrapping$
 Wrap=�6�   $	��Top=�6�   $	��179��6  ��67   ��  �� Path$ Nombre� �� NotifyOnValidationError .  �� ValidatesOnDataErrors . 6  (  "System.Windows.Controls.DatePicker  5   
   -   5          Name$ 	DateFecha��5   ?   $
��Left=�6R   $��
105,80,0,0q�6m   $	��Top=�6�   $	��177��6�      SelectedDate 6   �� $ FechaLimite�6�   �� 5   
   -   5         ��Name$ CheckFinalizada��5   9   $	��Sí��6R   $
��Left=�6_   $��105,119,0,0q�6z   $	��Top=�6�   	 d� 	IsChecked	 6   �� $ 
Finalizada�6�   �� 5   
   -   5        
 ��Name$
 BotonAceptar��5      $��Aceptar��6'   $
��Left=�69   $��207,231,0,0q�6T   $	��Top=�6i   $��75��6�   6�   �� 5   
   -   5        $ TextBoxDescripcion��5   4   $
��Left=�6P   $��23��6k   $��105,150,0,0q�6w   $
 Wrap=�6�   $	��Top=�6�   $	��177��6�   ��6   �� $ Descripcion�6�   �� 5   
   -   5        $
 BotonCancelar��5      $��Cancelar��6(   $
��Left=�6;   $��116,231,0,0q�6V   $	��Top=�6k   $��75��6�   6�   5      5      