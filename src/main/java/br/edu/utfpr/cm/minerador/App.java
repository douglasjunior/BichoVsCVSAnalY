package br.edu.utfpr.cm.minerador;

import br.edu.utfpr.cm.minerador.model.issue.Issue;
import br.edu.utfpr.cm.minerador.model.svn.Scmlog;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 *
 * HADOOP-NUMERO, MAPREDUCE-NUMERO e HDFS-NUMERO
 *
 *
 */
public class App {

    private static EntityManager emSvn;
    private static EntityManager emIssues;

    public static void main(String[] args) {
        connect();

        execute();
    }

    private static void connect() {
        emSvn = Persistence.createEntityManagerFactory("SVN").createEntityManager();

        emIssues = Persistence.createEntityManagerFactory("ISSUE").createEntityManager();
    }

    private static void execute() {
        final Pattern regex = Pattern.compile("A(?i)RIES-\\d+", Pattern.MULTILINE);

        //List<Issue> issues = emIssues.createQuery("SELECT p FROM Issue p").getResultList();
        //System.err.println(issues.size() + " issues");
        final List<Scmlog> commitMessages = emSvn.createQuery("SELECT s FROM Scmlog s").getResultList();
        System.err.println(commitMessages.size() + " commit messages");

        int contador = 0;

        emIssues.getTransaction().begin();

        for (Scmlog log : commitMessages) {
            final Matcher matcher = regex.matcher(log.getMessage());
            while (matcher.find()) {
                String issueKey = matcher.group(); // ARIES-1234
                // TODO for Bugzilla
                //issueId = emIssues.createQuery("SELECT p.issueId FROM IssueExtBugzilla p WHERE UPPER(p.issueKey) = " + issueKey.toUpperCase(), Integer.class).getSingleResult();
                contador++;
                try {
                    Issue issue = emIssues.createQuery("SELECT p FROM Issue p WHERE p.id = ("
                            + "SELECT p.issueId FROM IssueExtJira p WHERE UPPER(p.issueKey) = '"
                            + issueKey.toUpperCase() + "')", Issue.class).getSingleResult();
                    if (issue != null && issue.getId() != null) {
                        issue.addScmlog(log);
                        emIssues.merge(issue);
                        emIssues.flush();
                    }
                } catch (NoResultException e) {
                    System.out.println("Log: " + log.getId() + " / Ocorrência: " + issueKey + " / Não encontrado na base de dados.");
                }
            }

        }

        emIssues.getTransaction().commit();

        System.out.println(contador + " ocorrencias");
    }
}
