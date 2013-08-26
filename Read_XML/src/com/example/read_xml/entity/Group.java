package com.example.read_xml.entity;

import java.util.ArrayList;

public class Group {
	private String name=null;
	private ArrayList<Team> teams=null;
	private ArrayList<Game>games=null;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Team> getTeams() {
		return teams;
	}

	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}

	public ArrayList<Game> getGames() {
		return games;
	}
	public void setGames(ArrayList<Game> games) {
		this.games = games;
	}
	public Game getLastGame()
	{
		if (games.size()==0) {
			return null;
		}
		return games.get(games.size()-1);
	}
	
	public ArrayList<Game>findGamesByTeamName(String name)
	{
		ArrayList<Game>returnGames=new ArrayList<Game>();
		for (Game game : this.games) {
			if (game.getHome_name().equals(name)||game.getAway_name().equals(name)) {
				returnGames.add(game);
			}
		}
		return returnGames;
	}
}
