# DataValidationChainPattern

## Uygulamayı Çalıştırmak İçin
Uygulamayı çalıştırın: `mvn spring-boot:run`

## API Testi
API’yi test etmek için bir HTTP istemcisi (örneğin, Postman veya curl) kullanın:

### Başarılı Test
```bash
curl -X POST http://localhost:8080/api/register \
-H "Content-Type: application/json" \
-d '{"email":"kullanici@ornek.com","password":"guvenli123","username":"ali"}'
```
**Çıktı:** "Kayıt başarılı!"

### Hatalı Veri Testi
```bash
curl -X POST http://localhost:8080/api/register \
-H "Content-Type: application/json" \
-d '{"email":"gecersiz","password":"kisa","username":"ab"}'
```
**Çıktı:** "Kayıt başarısız: Geçersiz email formatı"

### Terminal Çıktısı
<img width="1600" height="795" alt="image" src="https://github.com/user-attachments/assets/3e4204b4-b124-45e5-8233-dd324baf60e8" />

