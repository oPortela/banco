package apresentacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contas")
public class ContaController {

    @Autowired
    private ContaRepository contaRepository;

    // Endpoint para criar uma conta
    @PostMapping
    public Conta criarConta(@RequestBody Conta conta) {
        return contaRepository.save(conta);
    }

    // Endpoint para listar todas as contas
    @GetMapping
    public List<Conta> listarContas() {
        return contaRepository.findAll();
    }

    // Endpoint para atualizar o saldo de uma conta
    @PutMapping("/{numero}")
    public Conta atualizarSaldo(@PathVariable String numero, @RequestBody Conta conta) {
        Conta existingConta = contaRepository.findById(numero).orElse(null);
        if (existingConta != null) {
            existingConta.setSaldo(conta.getSaldo());
            return contaRepository.save(existingConta);
        }
        return null;
    }

    // Endpoint para excluir uma conta
    @DeleteMapping("/{numero}")
    public void excluirConta(@PathVariable String numero) {
        contaRepository.deleteById(numero);
    }
}
