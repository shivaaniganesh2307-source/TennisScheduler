/*package com.tennisscheduler.controller;

import com.tennisscheduler.model.Tournament;
import com.tennisscheduler.repository.TournamentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final TournamentRepository tournamentRepository;

    public HomeController(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("tournaments", tournamentRepository.findAll());
        return "home";  // Uses merged home.html
    }
}*/
package com.tennisscheduler.controller;

import com.tennisscheduler.model.Tournament;
import com.tennisscheduler.model.Player;
import com.tennisscheduler.model.Match;
import com.tennisscheduler.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    private final TournamentRepository tournamentRepo;
    private final PlayerRepository playerRepo;
    private final MatchRepository matchRepo;

    public HomeController(TournamentRepository tr, PlayerRepository pr, MatchRepository mr){
        this.tournamentRepo = tr;
        this.playerRepo = pr;
        this.matchRepo = mr;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("tournaments", tournamentRepo.findAll());
        model.addAttribute("players", playerRepo.findAll());
        model.addAttribute("matches", matchRepo.findAll());
        return "home";
    }

    // Tournament
    @PostMapping("/tournaments/add")
    public String addTournament(@RequestParam String name, @RequestParam String location, @RequestParam String date){
        tournamentRepo.save(new Tournament(name, location, date));
        return "redirect:/";
    }
    @PostMapping("/tournaments/update")
    public String updateTournament(@RequestParam Long id, @RequestParam String name, @RequestParam String location, @RequestParam String date){
        tournamentRepo.findById(id).ifPresent(t -> { t.setName(name); t.setLocation(location); t.setDate(date); tournamentRepo.save(t); });
        return "redirect:/";
    }
    @PostMapping("/tournaments/delete")
    public String deleteTournament(@RequestParam Long id){
        tournamentRepo.deleteById(id);
        return "redirect:/";
    }

    // Player
    @PostMapping("/players/add")
    public String addPlayer(@RequestParam String name){
        playerRepo.save(new Player(name));
        return "redirect:/";
    }

    // Match
    @PostMapping("/matches/add")
    public String addMatch(@RequestParam Long tournamentId, @RequestParam Long player1Id, @RequestParam Long player2Id, @RequestParam String date){
        Tournament t = tournamentRepo.findById(tournamentId).orElse(null);
        Player p1 = playerRepo.findById(player1Id).orElse(null);
        Player p2 = playerRepo.findById(player2Id).orElse(null);
        if(t != null && p1 != null && p2 != null){
            matchRepo.save(new Match(t, p1, p2, date));
        }
        return "redirect:/";
    }
}