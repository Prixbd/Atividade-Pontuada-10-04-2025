    package com.example.Atividade.Pontuada.exception;

    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.http.converter.HttpMessageNotReadableException;
    import org.springframework.web.HttpRequestMethodNotSupportedException;
    import org.springframework.web.bind.MethodArgumentNotValidException;
    import org.springframework.web.bind.annotation.ExceptionHandler;
    import org.springframework.web.bind.annotation.RestControllerAdvice;
    import org.springframework.web.servlet.resource.NoResourceFoundException;

    import java.util.Map;

    @RestControllerAdvice
    public class GlobalExceptionHandler {
        @ExceptionHandler(RuntimeException.class)
        public ResponseEntity<Map<String, Object>> handlerRuntimeException(RuntimeException erro) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("mensagem", erro.getMessage()));
        }

        //pega excessoes de e-mail duplicado
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<Map<String, Object>> handMethodArgumentNotValidException(MethodArgumentNotValidException erro) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("mensagem", erro.getFieldErrors().get(0).getDefaultMessage()));
        }

        //tratamento de erro de validacao se caso um campo estiver em branco
        @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
        public ResponseEntity<Map<String, Object>> handlerHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException erro) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of("mensagem", "Recurso não encontrado."));
        }

        //tratamento pra quando o metodo https e imcompativel
        @ExceptionHandler(NoResourceFoundException.class)
        public ResponseEntity<Map<String, Object>> handlerNoResourceFoundException(NoResourceFoundException erro) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of("mensagem", "URL INVALIDA"));
        }

        //Serve pra quando a URL ou o formato tiver invalido
        @ExceptionHandler(HttpMessageNotReadableException.class)
        public ResponseEntity<Map<String, Object>> handlerHttpMessageNotReadableException(HttpMessageNotReadableException erro) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of("mensagem","Corpo da requisicao ausente ou mal formatado"));
        }
    }
