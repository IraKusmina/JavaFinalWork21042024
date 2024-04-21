package PracticeJava;

import java.util.Objects;

public class Notebook {
    private int ram;
    private int capacityHardDrive;
    private String operatingSystem;
    private String color;
    private String screen; // экран IPS VA OLED AMOLED
    private String storageDevice; //HDD SSD накопитель
    public Object getValue;

    public Notebook(int ram, int capacityHardDrive, String operatingSystem, String color, String screen, String storageDevice) {
        this.ram = ram;
        this.capacityHardDrive = capacityHardDrive;
        this.operatingSystem = operatingSystem;
        this.color = color;
        this.screen = screen;
        this.storageDevice = storageDevice;
    }

    public int getRam() {
        return ram;
    }

    public int getCapacityHardDrive(){
        return capacityHardDrive;
    }

    public String getOperatingSystem()  {
        return operatingSystem;
    }

    public String getColor()  {
        return color;
    }

    public String getScreen()  {
        return screen;
    }

    public String getStorageDevice()  {
        return storageDevice;
    }
    

    public void setRam (int ram) {
        this.ram = ram;
    }

    public void setCapacityHardDrive(int capacityHardDrive) {
        this.capacityHardDrive = capacityHardDrive;
    }

    public void setOperatingSystem(String operatingSystem){
        this.operatingSystem = operatingSystem;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setScreen(String screen){
        this.screen = screen;
    }

    public void setStorageDevice(String storageDevice){
        this.storageDevice = storageDevice;
    }

    @Override
    public String toString() {

        return "ОЗУ: " + ram + ", Объем ЖД: " + capacityHardDrive + ", Оперативная система:  " 
        + operatingSystem + ", Цвет: " + color + ", Экран:  " + screen + ", Накопитель: " + storageDevice;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (this == null || getClass() != obj.getClass())
            return false;
        Notebook notebook = (Notebook) obj;
        return (this.ram == notebook.ram) && (this.capacityHardDrive == notebook.capacityHardDrive) 
            && (this.operatingSystem == notebook.operatingSystem) && (this.color == notebook.color) 
            && (this.screen == notebook.screen) && (this.storageDevice == notebook.storageDevice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ram, capacityHardDrive, operatingSystem, color, screen, storageDevice);
    }
}
