create user victor4 identified by 'victor'
WITH 
		MAX_QUERIES_PER_HOUR 20

        MAX_UPDATES_PER_HOUR 10

        MAX_CONNECTIONS_PER_HOUR 5

        MAX_USER_CONNECTIONS 2;

grant all on tienda_virtual.* to victor4;