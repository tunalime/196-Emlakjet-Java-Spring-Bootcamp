## //	JAVA 11

### Launch Single-File Source-Code Programs – JEP 330
- Java dosyasınını hızlıca derlemeden çalıştırma özelliği gelmiştir.
```
java MerhabaJava.java
```
### Local-Variable Syntax for Lambda Parameters – JEP 323
- Java 10 ile gelen 'var' ifadesinin kapsamı genişletilerek lambda expressions ile kullanma imkanı gelmiştir.
```
public class App {

    public static void main(String[] args) {
        IntStream.of(1, 2, 3, 5, 6, 7)
                .filter((var i) -> i % 3 == 0)
                .forEach(System.out::println);
    }

 }
```
### Nest-Based Access Control – JEP 181
- Sınıf içerisinde yer alan alt sınıfların derlenmesinde değişiklik yapılarak nest olarak adlandırılan bir yapı kurulmuştur.
```
public class App {

    public static void main(String[] args) {
        Alt.yazdir();
    }

    static class Alt {
        private static void yazdir() {
            System.out.println("Mehmet Fethi Tunalı");
        }
    }

}
```

### HTTP Client (Standard) – JEP 321
- Java 9 ile birlikte gelen HTTP/2 Client Java 11 ile standart olarak java.net.http paketinde gelmektedir.

### String Methods
- String işlemlerini kolaylaştırmak için yeni metotlar eklenmiştir.

- strip, stripLeading, stripTrailing: trim metodundan farkı Unicode desteğinin olmasıdır.

- isBlank: String ifadesinin boşluk, Unicode boşluk değerine göre kontrol eder.

- lines: String ifadesindeki satır sonlandırıcına göre Stream API değeri verir.

- repeat: String ifadesini parametre değeri kadar tekrar eder.


### Collection
- Koleksiyonları dizilere çevirmek için toArray(IntFunction) metodu eklenmiştir.

### Files
- Dosya okuma ve yazma işlemlerini hızlıca yapmak için readString, writeString metotları eklenmiştir.

### Path
- Dosya/Dizin yolunu ifade etmek için kullanılan Path arayüzüne 'of' metotları eklenmiştir.

### java.io
- Java ile Input/Output işlemlerinde kullanılan java.io paketine yeni nullInputStream, nullOutputStream, nullReader, nullWriter, readNBytes metotları eklenmiştir.
FileReader ve FilterWriter sınıflarına yeni kurucu metotlar eklenmiştir.

### java.lang.Class
- Nest-based yapısına göre derlenen sınıflar ile ilgili detaylı bilgi almak için Class sınıfına getNestHost, getNestMembers, isNestmateOf metotları eklenmiştir.

### Diğer
- Docker, Kubernetes gibi bulut tabanlı ortamlarda işlemleri hızlandırmak için JEP 309 Dynamic Class-File Constants, JEP 318 Epsilon: A No-Op Garbage Collector, JEP 315 Improve Aarch64 Intrinsics, JEP 333 ZGC: A Scalable Low-Latency Garbage Collector (Experimental) gibi alt yapısal düzenlemeler yapılmıştır.


## //	JAVA 17


### Sealed Classes 
- Mühürlü sınıflar, diğer sınıfların bu sınıfları kullanabilmesini ve genişletebilmesini kısıtlar.

### Enhanced Pseudo-Random Number Generators 
- Bu sürüm, Pseudo-Random Number Generators için yeni arabirimler ve uygulamalar sağlar.

### Restore Always-Strict Floating-Point Semantics 
- Java 1.2'den beri Floating-Point sayılarıyla ilgili katı semantik gevşetilmiştir. Java 17, bu katı semantiği yerine geri koyar.

### Strongly Encapsulate JDK Internals 
- Bu özellik sayesinde, tek bir komut satırıyla dahili öğelerin güçlü encapsulation yapılarını gevşetmek artık mümkün olmayacak.
