--match ids where Sachin Tendulkar was player of the match against Australia
select r.gameId
from result r
inner join team t
on r.losingTeamId = t.id
and t.name = 'Australia'
inner join player p
on r.playerOfTheMatchId = p.id
and p.name = 'Sachin Tendulkar';



-- select those game Ids and player names where an Indian bowler was player of the Match order alphabetically by player names
select p.name as playerName,
	   r.gameId as gameId
from result r
inner join player p
on r.playerOfTheMatchId = p.id
inner join role ro
on p.roleId = ro.id
and ro.name = 'Batsman'
inner join team t
on p.teamId = t.id
and t.name = 'India'
order by playerName;

