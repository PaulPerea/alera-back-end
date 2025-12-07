DROP TABLE IF EXISTS "libros";

CREATE TABLE "libros" (
    "id" BIGINT AUTO_INCREMENT PRIMARY KEY,
    "titulo" VARCHAR(255) NOT NULL,
    "autor" VARCHAR(255) NOT NULL,
    "precio" DECIMAL(10, 2) NOT NULL,
    "created_at" TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Datos de prueba
INSERT INTO "libros" ("titulo", "autor", "precio") VALUES
('Clean Code', 'Robert C. Martin', 45.99),
('El Principito', 'Antoine de Saint-Exupéry', 19.99),
('1984', 'George Orwell', 24.99);