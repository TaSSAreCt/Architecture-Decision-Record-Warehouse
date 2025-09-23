# Architectural Decision Record

In the context of the Web shop service,
facing the need to keep user session data consistent and current across shop instances,
we decided for the Database Session State pattern
and against Client Session State or Server Session State
to achieve data consistency and cloud elasticity,
accepting that a session database needs to be designed and implemented.
