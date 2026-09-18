# Drivana — Proyecto Android Studio

Proyecto Kotlin generado a partir del diseño de Figma "Drivana" (login, registro,
inicio, búsqueda, carro, notificaciones, cuenta, ayuda, privacidad y
configuración), usando la paleta de colores del mockup (rojo, negro, ámbar,
verde y grises).

## Cómo abrirlo
1. Abre Android Studio → **Open** → selecciona la carpeta `Drivana`.
2. Deja que Android Studio genere el Gradle Wrapper si lo solicita (Sync
   automático). Se probó con **AGP 8.2.2**, **Kotlin 1.9.22**, `compileSdk 34`,
   `minSdk 24`.
3. Ejecuta en un emulador o dispositivo (▶ Run 'app').

## Estructura
```
app/src/main/java/com/drivana/app/
├── data/                  # Capa de persistencia (Room)
│   ├── User.kt            # Entidad (Model)
│   ├── UserDao.kt         # DAO: insertar y consultar usuarios
│   ├── AppDatabase.kt     # RoomDatabase con patrón Singleton
│   └── SessionManager.kt  # "Mantenerse en la sesión" con SharedPreferences
├── ui/entrada/             # Pantalla de bienvenida
├── ui/auth/                # LoginActivity y RegistroActivity
├── ui/main/                # MainActivity con BottomNavigationView
├── ui/inicio/               # Fragment "Inicio"
├── ui/busqueda/              # Fragment "Búsqueda" (grid de placeholders)
├── ui/carro/                # Fragment "Carro"
├── ui/notificaciones/       # Fragment "Notificaciones" + RecyclerView
└── ui/cuenta/                # Fragment "Cuenta" + Ayuda/Privacidad/Configuración
```

## Cómo cumple los requisitos de la práctica de Room
- **Entidad (Model):** `User.kt` — `id` (autogenerado), `correo`, `usuario`,
  `contrasena`. (Si tu rúbrica pide exactamente `nombre`, `apellidos`,
  `direccion`, `telefono`, cambia los campos de `User.kt`, `UserDao.kt` y los
  layouts de Registro en consecuencia — dímelo y lo ajusto.)
- **DAO:** `UserDao.kt` — `insertUser`, `login`, `countByUsuario`.
- **Database:** `AppDatabase.kt` — hereda de `RoomDatabase`, patrón Singleton
  con `getInstance(context)`.
- **UI:** `activity_registro.xml` / `activity_login.xml` con `EditText` +
  botón, siguiendo el diseño del mockup.
- **Controlador:** `RegistroActivity.kt` valida campos vacíos y ejecuta la
  inserción en segundo plano con `lifecycleScope.launch { ... }` (corrutinas),
  mostrando `Toast` de éxito o error.

## Pendiente de tu lado
- Capturas de pantalla / GIF de la app corriendo en el emulador (no puedo
  generar eso desde aquí).
- Capturas del código para el PDF de entrega (puedes usar Android Studio o
  este mismo repositorio).
- Subir a GitHub o comprimir en `.zip` **sin** la carpeta `build/`.
