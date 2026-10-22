# Comprensión del diseño — Enunciado B
**Nombre:** Sofia Piza Valderrama
**Fecha:** 19 de Octubre 2026

Responde con tus palabras, basándote en `docs/UML-final.md`. Respuestas
concisas (2–4 líneas por pregunta). Evidencia que entendiste el contrato
**antes** de programar.

---

### 1. Herencia y polimorfismo
¿Por qué `Modelo` es una clase abstracta y no concreta? Menciona qué método
obliga a cada subclase a implementar y qué gana el sistema con eso.

> _Tu respuesta:_ `Modelo` es abstracta porque es un concepto genérico que no se instancia por sí solo, obligando a las subclases a implementar el método `mejorLoss()`. Así, el sistema gana polimorfismo para gestionar cualquier modelo de forma uniforme a través del tipo padre.

---

### 2. Composición vs. agregación
Explica la diferencia entre `Experimento ◆— Modelo` (composición) y
`Plataforma ◇— Experimento` (agregación). ¿Qué pasaría con el modelo si se
elimina el experimento? ¿Y con los experimentos si se elimina la plataforma?

> _Tu respuesta:_ La composición (`Experimento - Modelo`) es una relación fuerte donde el experimento controla el ciclo de vida del modelo, por lo que si se elimina el experimento, el modelo también se destruye; en cambio, la agregación (`Plataforma - Experimento`) es una relación débil donde la plataforma contiene a los experimentos pero estos son independientes, de modo que si se elimina la plataforma, los experimentos sobreviven.

---

### 3. Asociación
En `Investigador — Experimento`, ¿quién es dueño de quién? ¿Por qué se modela
como N:M y no como composición?

> _Tu respuesta:_ En esta asociación no existe un dueño de propiedad exclusiva ya que ambos objetos son independientes. Se modela como N:M y no como composición porque un investigador puede tener varios experimentos y un experimento puede involucrar a múltiples investigadores, evitando que el ciclo de vida de uno dependa de la destrucción del otro.

---

### 4. Dependencia
¿Por qué `Modelo` **depende** de `MetricaEvaluacion` en lugar de **tenerlo**
como atributo? ¿Qué ventaja tiene pasar el servicio como parámetro?

> _Tu respuesta:_ `Modelo` depende de `MetricaEvaluacion` como parámetro porque la evaluación es una acción puntual y no un estado permanente del modelo. Esto reduce el acoplamiento y permite usar distintas métricas de forma flexible sin alterar el código interno.

---

### 5. Listas
En este proyecto se usan dos estructuras distintas:
- `int[] lossPorEpoca` en `Modelo`
- `ArrayList<Experimento>` en `Plataforma`

Explica por qué en cada caso se eligió esa estructura y no la otra.

> _Tu respuesta:_ Se usó `int[] lossPorEpoca` porque el número de épocas es fijo y conocido, optimizando memoria, mientras que `ArrayList<Experimento>` se eligió porque la cantidad de experimentos es dinámica y cambia constantemente.