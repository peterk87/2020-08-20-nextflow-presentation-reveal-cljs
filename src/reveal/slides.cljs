(ns reveal.slides
  (:require [reveal.util :as u
             :refer [data-auto-animate
                     img
                     img-stretch
                     style-green
                     height-3em
                     height-1em
                     height-2em
                     style-height
                     ]]))

(def title-slide
  [:section
   [:h2
    "An Intro to " [:span {:style u/color-green}
                    "Next"] "flow"]
   [:p "Use and create powerful, reproducible workflows for bioinformatics"]
   (for [x ["Bioinformatics Pipeline Building Meeting - August, 20, 2020"
            "Peter Kruczkiewicz"
            [:span "Genomics Unit, NCFAD, CFIA " (u/img "canada.png")]]]
     [:p (u/font-size-style 0.5) x])
   ])

(def code-snippet-install-nextflow-locally
  "$ curl -s https://get.nextflow.io | bash
# move 'nextflow' binary to directory in PATH
$ mkdir -p ~/bin/
$ mv nextflow ~/bin/")

(def notes-what-is-nextflow
  "Nextflow manages or helps you execute analyses specified in workflows. Those workflows are specified in a domain specific language. It allows you to focus on the analysis you wish to perform and not the details about how it should be executed. But you need to learn its language.")

(def slide-what-is-nextflow
  [:section {:data-notes notes-what-is-nextflow}
   [:h3 "What is " (img "nextflow_logo.png") "?"]
   [:ul
    [:li "Workflow execution manager"]
    [:li "Workflow specification language"]]])

(def slide-bash-make-workflow
  [:section
   [:section data-auto-animate
    [:h4 "But I already use Bash/Python/Make/etc for my workflows!"]
    [:small
     [:ul
      [:li "How do you handle multiple samples? Concurrency?"]]]]
   [:section data-auto-animate
    [:h4 "But I already use Bash/Python/Make/etc for my workflows!"]
    [:small
     [:ul
      [:li "How do you handle multiple samples? Concurrency?"]
      [:li "Can you execute your workflow on a HPC cluster? Cloud?"]]]]
   [:section data-auto-animate
    [:h4 "But I already use Bash/Python/Make/etc for my workflows!"]
    [:small
     [:ul
      [:li "How do you handle multiple samples? Concurrency?"]
      [:li "Can you execute your workflow on a HPC cluster? Cloud?"]
      [:li "How do you handle potentially conflicting software dependencies? Software versions?"]]]]
   [:section data-auto-animate
    [:h4 "But I already use Bash/Python/Make/etc for my workflows!"]
    [:small
     [:ul
      [:li "How do you handle multiple samples? Concurrency?"]
      [:li "Can you execute your workflow on a HPC cluster? Cloud?"]
      [:li "How do you handle potentially conflicting software dependencies? Software versions?"]
      [:li "Is your workflow reproducible?"]]]]])

(def slide-nextflow-overview
  [:section
   [:h1
    (img "nextflow_logo.png")]
   [:ul
    [:li "Rapid Development"]
    [:li "Simple Concurrency"]
    [:li "Scalability and Portability"]
    [:li "Reproducibility"]]])

(def slide-nextflow-overview-rapid-dev
  [:section
   [:section data-auto-animate
    [:h3 style-green "Rapid Development"]
    [:ul
     [:li "Quickly create a Nextflow workflow from a few command-lines"]
     ]]
   [:section data-auto-animate
    [:h3 style-green "Rapid Development"]
    [:ul
     [:li "Quickly create a Nextflow workflow from a few command-lines"]
     [:li "Convert an existing workflow"]
     [:ul
      [:li "Procedural single-threaded Bash/Python script to scalable Nextflow workflow"]]]]
   [:section data-auto-animate
    [:h3 style-green "Rapid Development"]
    [:ul
     [:li "Quickly create a Nextflow workflow from a few command-lines"]
     [:li "Convert an existing workflow"]
     [:ul
      [:li "Procedural single-threaded Bash/Python script to scalable Nextflow workflow"]]]
    [:p style-green "Prototype " [:i.fas.fa-arrow-right] " Production Ready Workflow"]]])

(def slide-nextflow-overview-concurrency
  [:section
   [:section data-auto-animate
    [:h3 style-green "Simple Concurrency"]
    [:p "Easily run things in parallel"]
    [:span {:data-id "assembly1"}
     (img "assembly.png" height-3em)]]
   [:section data-auto-animate
    [:h3 style-green "Simple Concurrency"]
    [:p "Easily run things in parallel"]
    (for [i (range 10)] (for [_ (range 10)]
                          [:span {:data-id (str "assembly" i)}
                           (img "assembly.png" height-1em)]))]])

(def slide-nextflow-overview-scalability
  [:section
   ;; Scalability
   [:section data-auto-animate
    [:h3 style-green "Scalability and Portability"]
    [:div.row.align-items-center
     [:div.col-2.offset-5
      (img "computer.png" height-3em {:data-id "computer"})]]
    [:div.row
     [:p "Execution in different environments"]]
    [:div.row
     [:ul
      [:li "Local"]]]]
   [:section data-auto-animate
    [:h3 style-green "Scalability and Portability"]
    [:div.row.align-items-center
     [:div.col-2.offset-3
      (img "computer.png" height-3em {:data-id "computer"})]
     [:div.col-1
      [:i.fas.fa-arrow-right {:data-id "r1"}]]
     [:div.col-4
      (img "cluster.jpg" (style-height 4) {:data-id "cluster"})]]
    [:div.row
     [:p "Execution in different environments"]]
    [:div.row
     [:ul
      [:li "Local"]
      [:li "Cluster (support for many different schedulers)"]]]]
   [:section data-auto-animate
    [:h3 style-green "Scalability and Portability"]
    [:div.row.align-items-center
     [:div.col-2.offset-1
      (img "computer.png" height-3em {:data-id "computer"})]
     [:div.col-1
      [:i.fas.fa-arrow-right {:data-id "r1"}]]
     [:div.col-4
      (img "cluster.jpg" (style-height 4) {:data-id "cluster"})]
     [:div.col-1
      [:i.fas.fa-arrow-right]]
     [:div.col-1
      [:span.fa-stack
       [:i.fas.fa-cloud.fa-stack-2x {:style "color: #a2d1ef"}]
       [:i.fab.fa-aws.fa-stack-1x]]]]
    [:div.row
     [:p "Execution in different environments"]]
    [:div.row
     [:ul
      [:li "Local"]
      [:li "Cluster (support for many different schedulers)"]
      [:li "Cloud (AWS, GCP, Kubernetes)"]]]]])

(def slide-nextflow-overview-reproducibility
  [:section
   [:section data-auto-animate
    [:h3 style-green "Reproducibility"]
    [:div.row
     [:p "Manage software dependencies"]]
    [:div.row.align-items-center
     [:div.col-4
      (img "conda_logo.svg")]
     [:div.col-4
      (img "docker_logo.svg")]
     [:div.col-4 {:data-id "Singularity"}
      [:span "Singularity " (img "singularity.png")]]]]
   [:section data-auto-animate
    [:h3 style-green "Reproducibility"]
    [:div.row
     [:p "Manage software dependencies"]]
    [:div.row.align-items-center
     [:div.col-4
      (img "conda_logo.svg")]
     [:div.col-4
      (img "docker_logo.svg")]
     [:div.col-4 {:data-id "Singularity"}
      [:span "Singularity " (img "singularity.png")]]]
    [:div.row
     [:p "Share and distribute workflows with Git and Github"]]
    [:div.row.align-items-center
     [:div.col-2.offset-3
      [:i.fas.fa-share-alt.fa-2x {:data-id "share-icon"}]]
     [:div.col-2
      [:i.fab.fa-git.fa-2x {:data-id "git-icon"}]]
     [:div.col-2
      [:i.fab.fa-github.fa-2x {:data-id "github-icon"}]]]]
   [:section data-auto-animate
    [:h3 style-green "Reproducibility"]
    [:div.row
     [:p "Manage software dependencies"]]
    [:div.row.align-items-center
     [:div.col-4
      (img "conda_logo.svg")]
     [:div.col-4
      (img "docker_logo.svg")]
     [:div.col-4 {:data-id "Singularity"}
      [:span "Singularity " (img "singularity.png")]]]
    [:div.row
     [:p "Share and distribute workflows with Git and Github"]]
    [:div.row.align-items-center
     [:div.col-2.offset-3
      [:i.fas.fa-share-alt.fa-2x {:data-id "share-icon"}]]
     [:div.col-2
      [:i.fab.fa-git.fa-2x {:data-id "git-icon"}]]
     [:div.col-2
      [:i.fab.fa-github.fa-2x {:data-id "github-icon"}]]]
    [:div.row
     [:p "Self-contained workflows that run the same anywhere!"]]]])

(def slide-nextflow-paper-figure-1
  [:section
   [:section
    [:img.r-stretch {:data-src "img/tommaso-2017-nextflow-figure-1-reproducibility.png"}]
    [:small u/nextflow-citation]]
   [:section
    [:img.r-stretch {:data-src "img/tommaso-2017-nextflow-figure-1-reproducibility-a.png"}]
    [:small u/nextflow-citation]]
   [:section
    [:img.r-stretch {:data-src "img/tommaso-2017-nextflow-figure-1-reproducibility-b.png"}]
    [:small u/nextflow-citation]]
   [:section
    [:img.r-stretch {:data-src "img/tommaso-2017-nextflow-figure-1-reproducibility-c.png"}]
    [:small u/nextflow-citation]]])

(def slide-easy-to-install
  [:section
   [:h3 style-green "Easy to Install"]
   [:p "Install with " (img "conda_logo.svg") " from " (img "bioconda.png")]
   [:pre [:code.bash
          "$ conda install -c conda-forge -c bioconda nextflow"]]
   [:p "Or install manually (need Java 8+)"]
   [:pre
    [:code.bash code-snippet-install-nextflow-locally]]
   [:p "Run a test workflow!"]
   [:pre
    [:code.bash "$ nextflow run hello"]]])

(def slide-run-hello-1
  [:section
   [:h3 "Run test Nextflow workflow"]
   [:img {:data-src "img/nf-hello.svg"}]])

(def slide-run-hello-2
  [:section
   (img-stretch "github-nextflow-hello.png")])

(def slide-run-hello-3
  [:section
   [:h3 "nextflow-io/hello"]
   [:code "main.nf"]
   [:pre
    [:code.groovy
     "#!/usr/bin/env nextflow
cheers = Channel.from 'Bonjour', 'Ciao', 'Hello', 'Hola'

process sayHello {
  echo true
  input:
    val x from cheers
  script:
    \"\"\"
    echo '$x world!'
    \"\"\"
}"]]
   [:ul
    [:li [:em "What is a Channel?"]]
    [:li [:em "What is a Process?"]]]])

(def slide-nextflow-concepts
  [:section
   [:section data-auto-animate
    [:h3 [:span style-green "Nextflow "] "| Concepts"]
    [:ul
     [:li [:strong "Processes"]]
     [:ul
      [:li "Building blocks of a workflow"]
      [:li "Contain command lines or Python/Perl/R/etc code to execute as " [:em "Tasks"]]]]
    [:p (img "pipeline-schematic-1.svg" (style-height 4))]]
   [:section data-auto-animate
    [:h3 [:span style-green "Nextflow"] " | Concepts"]
    [:ul
     [:li [:strong "Processes"]]
     [:ul
      [:li "Building blocks of a workflow"]
      [:li "Contain command lines or Python/Perl/R/etc code to execute as " [:em "Tasks"]]]
     [:li [:strong "Channels"]
      [:ul
       [:li "How data is sent to and between " [:em "channels"]]]]]
    [:p (img "pipeline-schematic-2.svg" (style-height 4))]]
   [:section data-auto-animate
    [:h3 [:span style-green "Nextflow"] " | Concepts"]
    [:p "Data " [:em "flows"] " between " [:strong "Processes"] " via " [:strong "Channels"]]
    [:p (img "pipeline-schematic-2.svg" (style-height 4))]]
   [:section data-auto-animate
    [:h3 [:span style-green "Nextflow"] " | Concepts"]
    [:p "Data " [:em "flows"] " between " [:strong "Processes"] " via " [:strong "Channels"]]
    (img-stretch "float-down-river.jpg")
    [:small [:small "source: https://cdn.onlyinyourstate.com/wp-content/uploads/2017/05/IMG_1896-700x526.jpg"]]]
   [:section data-auto-animate
    [:h3 [:span style-green "Nextflow"] " | Concepts"]
    [:p "Data " [:em "flows"] " between " [:strong "Processes"] " via " [:strong "Channels"]]
    (img-stretch "conveyor-belt.jpg")
    [:small [:small "source: https://media.gettyimages.com/vectors/packages-conveyor-belt-drawing-vector-id466730657"]]]])

(def slide-tower-nf
  [:section {:data-background-iframe      "https://tower.nf/"
             :data-background-interactive "data-background-interactive"}
   [:div ""]])

(def slide-tower-1
  [:section
   [:section
    (u/img-stretch "nf-tower-viralrecon.png")]
   [:section
    (u/img-stretch "nf-tower-viralrecon-2.png")]
   [:section
    (u/img-stretch "nf-tower-viralrecon-3.png")]])

(def slide-compare-workflow-mgmt-systems
  [:section
   (u/img-stretch "tommaso-2017-nextflow-table-1.png")
   [:small [:small u/nextflow-citation]]
   [:small [:em "* From 2017 so slightly out-of-date. Nextflow has workflow modules now with DSL 2"]]
   ])

(def slide-example
  [:section [:h3 [:span style-green "Nextflow"] " | Example workflow"]])

(def slide-example-code
  [:section
   [:section u/data-auto-animate
    [:h3 "Example Workflow"]
    [:div.row
     [:small
      [:ul
       [:li "Assemble reads into contigs with SPAdes"]
       [:li "BLAST search contigs against a BLAST DB"]
       [:li "Generate a report of all BLAST results"]]]]
    [:small
     [:p {:style "margin-bottom:0px;"} "Bash script for SPAdes assembly"]]
    [:pre {:data-id "code"}
     [:code.bash {:data-line-numbers "data-line-numbers"}
      "#!/usr/bin/env bash

reads1=$1
reads2=$2
output=$3

spades.py -1 $reads1 -2 $reads2 -o $output"]]]
   [:section u/data-auto-animate
    [:div {:style "font-size:0.6em;"}
     [:pre {:data-id "code"}
             [:code.bash {:data-line-numbers "data-line-numbers"}
              "#!/usr/bin/env bash

reads1=$1
reads2=$2
output=$3

spades.py -1 $reads1 -2 $reads2 -o $output"]]]
    [:p "Convert to " [:span style-green "Nextflow"]]
    [:div {:style "font-size:0.8em;"}
     [:pre {:data-id "spades-process"}
      [:code.groovy {:data-line-numbers ""}
       "#!/usr/bin/env nextflow
// Use new cleaner, simpler syntax
nextflow.enable.dsl=2

process SPADES {
 input:
 tuple sample_id, path(reads)
 output:
 tuple sample_id, path(\"out/\")

 script:
 \"\"\"
 spades.py -1 ${reads[0]} -2 ${reads[1]} -o out
 \"\"\"
}"]]]]
   [:section u/data-auto-animate
    [:div {:style "font-size:0.6em;"}
     [:pre {:data-id "code"}
      [:code.bash {:data-line-numbers "7"}
       "#!/usr/bin/env bash

reads1=$1
reads2=$2
output=$3

spades.py -1 $reads1 -2 $reads2 -o $output"]]]
    [:p "Convert to " [:span style-green "Nextflow"]]
    [:div {:style "font-size:0.8em;"}
     [:pre {:data-id "spades-process"}
      [:code.groovy {:data-line-numbers "13"}
       "#!/usr/bin/env nextflow
// Use new cleaner, simpler syntax
nextflow.enable.dsl=2

process SPADES {
 input:
 tuple sample_id, path(reads)
 output:
 tuple sample_id, path(\"out/\")

 script:
 \"\"\"
 spades.py -1 ${reads[0]} -2 ${reads[1]} -o out
 \"\"\"
}"]]]]
   [:section u/data-auto-animate
    [:div {:style "font-size:0.8em;"}
     [:pre {:data-id "spades-process"}
      [:code.groovy {:data-line-numbers "4,18-21"}
       "#!/usr/bin/env nextflow
nextflow.enable.dsl=2

params.reads = \"reads/*_R{1,2}*.fastq.gz\"

process SPADES {
 input:
 tuple sample_id, path(reads)
 output:
 tuple sample_id, path(\"out/\")

 script:
 \"\"\"
 spades.py -1 ${reads[0]} -2 ${reads[1]} -o out
 \"\"\"
}
...
workflow {
 reads = Channel.fromFilePairs(params.reads)
 reads | SPADES | BLAST | collect | REPORT
}"]]]]
   [:section u/data-auto-animate
    [:div {:style "font-size:0.8em;"}
     [:pre {:data-id "spades-process"}
      [:code.groovy {:data-line-numbers "22-24"}
       "#!/usr/bin/env nextflow
nextflow.enable.dsl=2

params.reads = \"reads/*_R{1,2}*.fastq.gz\"

process SPADES {
 input:
 tuple sample_id, path(reads)
 output:
 tuple sample_id, path(\"out/\")

 script:
 \"\"\"
 spades.py -1 ${reads[0]} -2 ${reads[1]} -o out
 \"\"\"
}
...
workflow {
 reads = Channel.fromFilePairs(params.reads)
 reads | SPADES | BLAST | collect | REPORT
 // OR
 SPADES(reads)
 BLAST(SPADES.out)
 REPORT(BLAST.out.collect())
}"]]]]
   [:section u/data-auto-animate
    [:div {:style "font-size:0.8em;"}
     [:pre {:data-id "spades-process"}
      [:code.groovy {:data-line-numbers "4,18-21"}
       "#!/usr/bin/env nextflow
nextflow.enable.dsl=2

params.reads = \"reads/*_R{1,2}*.fastq.gz\"

process SPADES {
 input:
 tuple sample_id, path(reads)
 output:
 tuple sample_id, path(\"out/\")

 script:
 \"\"\"
 spades.py -1 ${reads[0]} -2 ${reads[1]} -o out
 \"\"\"
}
...
workflow {
 reads = Channel.fromFilePairs(params.reads)
 reads | SPADES | BLAST | collect | REPORT
}"]]]
    [:pre
     [:code.bash "$ nextflow run my-workflow.nf \\
     --reads \"/path/to/reads/*_{1,2}.fastq\""]]
    [:p "Where are my results?"]]
   [:section u/data-auto-animate
    [:h5 "You need to " [:em "publish"] " your results"]
    [:div {:style "font-size:0.8em;"}
     [:pre {:data-id "spades-process"}
      [:code.groovy {:data-line-numbers "4,7,8"}
       "#!/usr/bin/env nextflow
nextflow.enable.dsl=2
params.reads = \"reads/*_R{1,2}*.fastq.gz\"
params.outdir = \"results\"

process SPADES {
 publishDir \"${params.outdir}/spades/$sample_id\",
            pattern: 'out/*'
 input:
 tuple sample_id, path(reads)
 output:
 tuple sample_id, path(\"out/\")

 script:
 \"\"\"
 spades.py -1 ${reads[0]} -2 ${reads[1]} -o out
 \"\"\"
}
...
workflow {
 reads = Channel.fromFilePairs(params.reads)
 reads | SPADES | BLAST | collect | REPORT
}"]]]
    [:pre
     [:code.bash "$ nextflow run my-workflow.nf \\
     --reads \"/path/to/reads/*_{1,2}.fastq\""]]]])

(def slide-work-dir
  [:section
   [:section data-auto-animate
    [:h3 "The Work Directory"]]
   [:section data-auto-animate
    [:h3 "The Work Directory"]
    [:ul
     [:li "Where analyses are performed"]]]
   [:section data-auto-animate
    [:h3 "The Work Directory"]
    [:ul
     [:li "Where analyses are performed"]
     [:li "Each task gets its own " [:em "unique"] " subdirectory"]
     [:small
      [:ul
       [:li "For example: " [:code "work/01/5a23f79dd64fbb1e0a7e3b10fced5f"]]]]]]
   [:section data-auto-animate
    [:h3 "The Work Directory"]
    [:ul
     [:li "Where analyses are performed"]
     [:li "Each task gets its own " [:em "unique"] " subdirectory"]
     [:small
      [:ul
       [:li "For example: " [:code "work/01/5a23f79dd64fbb1e0a7e3b10fced5f"]]]]
     [:li "Sandboxed analysis environment"]]]
   [:section data-auto-animate
    [:h3 "The Work Directory"]
    [:ul
     [:li "Where analyses are performed"]
     [:li "Each task gets its own " [:em "unique"] " subdirectory"]
     [:small
      [:ul
       [:li "For example: " [:code "work/01/5a23f79dd64fbb1e0a7e3b10fced5f"]]]]
     [:li "Sandboxed analysis environment"]
     [:li "One analysis task should not interfere with any other analysis task"]]]])

(def slide-work-dir-example
  [:section
   (img-stretch "nf-work.svg")])

(def slide-work-dir-breakdown
  [:section
   [:section data-auto-animate
    [:h3 "Task Work Directory"]
    [:ul
     [:li "Input data " [:em "symlinked"] " into task dir"]
     [:small [:ul [:li "No copies of Process input are made"]]]
     [:li "Where you'll find task output data"]
     [:li "Multiple " [:em "hidden"] " files (dotfiles)"]]]
   [:section data-auto-animate
    [:h3 "Task Work Directory"]
    [:ul
     [:li "Input data " [:em "symlinked"] " into task dir"]
     [:small [:ul [:li "No copies of Process input are made"]]]
     [:li "Where you'll find task output data"]
     [:li "Multiple " [:em "hidden"] " files (dotfiles)"]
     [:small
      [:ul
       [:li [:code style-green ".command.sh"] " is analysis task script"]]]]]
   [:section data-auto-animate
    [:h3 "Task Work Directory"]
    [:ul
     [:li "Input data " [:em "symlinked"] " into task dir"]
     [:small [:ul [:li "No copies of Process input are made"]]]
     [:li "Where you'll find task output data"]
     [:li "Multiple " [:em "hidden"] " files (dotfiles)"]
     [:small
      [:ul
       [:li [:code style-green ".command.sh"] " is analysis task script"]
       [:li [:code style-green ".command.run"] " is the Nextflow-generated Bash script that executes " [:code ".command.sh"] " and captures log, trace and exit code info"]]]]]
   [:section data-auto-animate
    [:h3 "Task Work Directory"]
    [:ul
     [:li "Input data " [:em "symlinked"] " into task dir"]
     [:small [:ul [:li "No copies of Process input are made"]]]
     [:li "Where you'll find task output data"]
     [:li "Multiple " [:em "hidden"] " files (dotfiles)"]
     [:small
      [:ul
       [:li [:code style-green ".command.sh"] " is analysis task script"]
       [:li [:code style-green ".command.run"] " is the Nextflow-generated Bash script that executes " [:code ".command.sh"] " and captures log, trace and exit code info"]
       [:li [:code style-green ".command.log"] " is where stdout/stderr info is captured"]]]]]
   [:section data-auto-animate
    [:h3 "Task Work Directory"]
    [:ul
     [:li "Input data " [:em "symlinked"] " into task dir"]
     [:small [:ul [:li "No copies of Process input are made"]]]
     [:li "Where you'll find task output data"]
     [:li "Multiple " [:em "hidden"] " files (dotfiles)"]
     [:small
      [:ul
       [:li [:code style-green ".command.sh"] " is analysis task script"]
       [:li [:code style-green ".command.run"] " is the Nextflow-generated Bash script that executes " [:code ".command.sh"] " and captures log, trace and exit code info"]
       [:li [:code style-green ".command.log"] " is where stdout/stderr info is captured"]
       [:ul
        [:li [:em "You don't need to do it yourself like with Snakemake!"]]
        [:li "stdout and stderr are also captured separately. See " [:code ".command.out"] " and " [:code ".command.err"]]]]]]]
   [:section data-auto-animate
    [:h3 "Task Work Directory"]
    [:ul
     [:li "Input data " [:em "symlinked"] " into task dir"]
     [:small [:ul [:li "No copies of Process input are made"]]]
     [:li "Where you'll find task output data"]
     [:li "Multiple " [:em "hidden"] " files (dotfiles)"]
     [:small
      [:ul
       [:li [:code style-green ".command.sh"] " is analysis task script"]
       [:li [:code style-green ".command.run"] " is the Nextflow-generated Bash script that executes " [:code ".command.sh"] " and captures log, trace and exit code info"]
       [:li [:code style-green ".command.log"] " is where stdout/stderr info is captured"]
       [:ul
        [:li [:em "You don't need to do it yourself like with Snakemake!"]]
        [:li "stdout and stderr are also captured separately. See " [:code ".command.out"] " and " [:code ".command.err"]]]
       [:li [:code style-green ".command.trace"] " for trace info (CPU, memory, IO usage, etc)"]
       ]]
     ]]
   [:section data-auto-animate
    [:h3 "Task Work Directory"]
    [:ul
     [:li "Input data " [:em "symlinked"] " into task dir"]
     [:small [:ul [:li "No copies of Process input are made"]]]
     [:li "Where you'll find task output data"]
     [:li "Multiple " [:em "hidden"] " files (dotfiles)"]
     [:small
      [:ul
       [:li [:code style-green ".command.sh"] " is analysis task script"]
       [:li [:code style-green ".command.run"] " is the Nextflow-generated Bash script that executes " [:code ".command.sh"] " and captures log, trace and exit code info"]
       [:li [:code style-green ".command.log"] " is where stdout/stderr info is captured"]
       [:ul
        [:li [:em "You don't need to do it yourself like with Snakemake!"]]
        [:li "stdout and stderr are also captured separately. See " [:code ".command.out"] " and " [:code ".command.err"]]]
       [:li [:code style-green ".command.trace"] " for trace info (CPU, memory, IO usage, etc)"]
       [:li [:code style-green ".exitcode"] " contains the exit code for the task execution"]
       [:small [:ul [:li "e.g. 0 for successful execution; non-zero for an error"]]]]]
     ]]])

(def slide-config
  [:section
   [:section data-auto-animate
    [:h3 [:span style-green "Nextflow "] "| Configuration"]
    [:ul
     [:li "Decouple " [:em "what"] " your workflow is doing from " [:em "how"]]]]
   [:section data-auto-animate
    [:h3 [:span style-green "Nextflow "] "| Configuration"]
    [:ul
     [:li "Decouple " [:em "what"] " your workflow is doing from " [:em "how"]]
     [:small
      [:ul
       [:li [:code style-green "nextflow.config"] " for configuration"]
       [:li [:code style-green "main.nf"] " for the " [:em "main"] " workflow"]]]]]
   [:section data-auto-animate
    [:h3 [:span style-green "Nextflow "] "| Configuration"]
    [:ul
     [:li "Decouple " [:em "what"] " your workflow is doing from " [:em "how"]]
     [:small
      [:ul
       [:li [:code style-green "nextflow.config"] " for configuration"]
       [:li [:code style-green "main.nf"] " for the " [:em "main"] " workflow"]]]
     [:li "Set up different configuration profiles"]]]
   [:section data-auto-animate
    [:h3 [:span style-green "Nextflow "] "| Configuration"]
    [:ul
     [:li "Decouple " [:em "what"] " your workflow is doing from " [:em "how"]]
     [:small
      [:ul
       [:li [:code style-green "nextflow.config"] " for configuration"]
       [:li [:code style-green "main.nf"] " for the " [:em "main"] " workflow"]]]
     [:li "Set up different configuration profiles"]
     [:small
      [:ul
       [:li "Profiles for execution in different environments (e.g. local, Slurm cluster, AWS cloud)"]
       [:li "Conda, Docker, Singularity profiles"]
       [:li "Testing profiles (continuous integration testing)"]]]]]
   [:section data-auto-animate
    [:h3 [:span style-green "Nextflow "] "| Configuration"]
    [:ul
     [:li "Decouple " [:em "what"] " your workflow is doing from " [:em "how"]]
     [:small
      [:ul
       [:li [:code style-green "nextflow.config"] " for configuration"]
       [:li [:code style-green "main.nf"] " for the " [:em "main"] " workflow"]]]
     [:li "Set up different configuration profiles"]
     [:small
      [:ul
       [:li "Profiles for execution in different environments (e.g. local, Slurm cluster, AWS cloud)"]
       [:li "Conda, Docker, Singularity profiles"]
       [:li "Testing profiles (continuous integration testing)"]]]
     ]
    [:pre
     [:code.bash "$ nextflow run main.nf -profile singularity,slurm --input args"]]]])

(def slide-dsl2
  [:section
   [:section data-auto-animate
    [:h3 [:span style-green "Nextflow"] " | DSL 2"]
    [:ul
     [:li "Cleaner, simpler syntax"]
     [:li "Easier to see what a workflow is doing"]
     [:li "Easier to get started with Nextflow"]]
    ]
   [:section data-auto-animate
    [:h3 [:span style-green "Nextflow"] " | DSL 2"]
    [:ul
     [:li "Cleaner, simpler syntax"]
     [:li "Easier to see what a workflow is doing"]
     [:li "Easier to get started with Nextflow"]
     [:li "Automatic channel forking"]]
    [:div.row {:style "font-size:0.7em;"}
     [:div.col-6
      [:p "DSL 2"]
      [:pre
       [:code.groovy
        {:data-line-numbers "4,9,13,14"}
        "// DSL 2 automatic channel forking
process FASTQC {
  input:
  path(reads)
  ...
}
process SPADES {
  input:
  path(reads)
  ...
}
workflow {
  reads = Channel.fromPath(params.reads)
  reads | (FASTQC & SPADES & KRAKEN2)
}
"]]]
     [:div.col-6
      [:p "DSL 1"]
      [:pre
       [:code.groovy
        {:data-line-numbers "3,4,5,8,13"}
        "// DSL 1 manual channel forking
Channel.fromPath(params.reads)
    .into { reads_fastqc;
            reads_spades;
            reads_kraken2 }
process FASTQC {
  input:
  path(reads) from reads_fastqc
  ...
}
process SPADES {
  input:
  path(reads) from reads_spades
  ...
}
                   "]]]]]
   [:section data-auto-animate
    [:h3 [:span style-green "Nextflow"] " | DSL 2"]
    [:ul
     [:li "Cleaner, simpler syntax"]
     [:li "Easier to see what a workflow is doing"]
     [:li "Easier to get started with Nextflow"]
     [:li "Automatic channel forking"]
     [:li "Modules of functions, processes and workflows"]
     [:small
      [:ul
       [:li "Don't need to repeat yourself"]
       [:li "e.g. include a modular process in multiple parts of your overall workflow"]
       [:li "Split a large workflow into multiple smaller workflows"]]]]]])

(def slide-nf-core
  [:section
   [:img.plain {:data-src "https://nf-co.re/assets/img/logo/nf-core-logo.svg"
                :style "height:3em;"}]
   [:small [:blockquote "A community effort to collect a curated set of analysis pipelines built using Nextflow."]]
   (img-stretch "nf-core-values.png")
   [:small [:small u/nf-core-citation]]])

(def slide-nf-core-pipelines
  [:section
   [:h3 "nf-core pipelines"]
   (img-stretch "nf-core-pipelines.png")
   ])

(def slide-nf-core-viralrecon
  [:section {:data-markdown ""
             :style "font-size:0.35em;"}
   [:textarea {:data-template ""}
    "## nf-core/viralrecon <i class=\"fas fa-viruses\" style=\"color:rgb(39, 174, 96);\"></i>

Assembly and intrahost/low-frequency variant calling for viral samples

https://github.com/nf-core/viralrecon

### Pipeline summary

1. Download samples via SRA, ENA or GEO ids ([`ENA FTP`](https://ena-docs.readthedocs.io/en/latest/retrieval/file-download.html), [`parallel-fastq-dump`](https://github.com/rvalieris/parallel-fastq-dump); *if required*)
2. Merge re-sequenced FastQ files ([`cat`](http://www.linfo.org/cat.html); *if required*)
3. Read QC ([`FastQC`](https://www.bioinformatics.babraham.ac.uk/projects/fastqc/))
4. Adapter trimming ([`fastp`](https://github.com/OpenGene/fastp))
5. Variant calling
    1. Read alignment ([`Bowtie 2`](http://bowtie-bio.sourceforge.net/bowtie2/index.shtml))
    2. Sort and index alignments ([`SAMtools`](https://sourceforge.net/projects/samtools/files/samtools/))
    3. Primer sequence removal ([`iVar`](https://github.com/andersen-lab/ivar); *amplicon data only*)
    4. Duplicate read marking ([`picard`](https://broadinstitute.github.io/picard/); *removal optional*)
    5. Alignment-level QC ([`picard`](https://broadinstitute.github.io/picard/), [`SAMtools`](https://sourceforge.net/projects/samtools/files/samtools/))
    6. Genome-wide and amplicon coverage QC plots ([`mosdepth`](https://github.com/brentp/mosdepth/))
    7. Choice of multiple variant calling and consensus sequence generation routes ([`VarScan 2`](http://dkoboldt.github.io/varscan/), [`BCFTools`](http://samtools.github.io/bcftools/bcftools.html), [`BEDTools`](https://github.com/arq5x/bedtools2/) *||* [`iVar variants and consensus`](https://github.com/andersen-lab/ivar) *||* [`BCFTools`](http://samtools.github.io/bcftools/bcftools.html), [`BEDTools`](https://github.com/arq5x/bedtools2/))
        * Variant annotation ([`SnpEff`](http://snpeff.sourceforge.net/SnpEff.html), [`SnpSift`](http://snpeff.sourceforge.net/SnpSift.html))
        * Consensus assessment report ([`QUAST`](http://quast.sourceforge.net/quast))
    8. Intersect variants across callers ([`BCFTools`](http://samtools.github.io/bcftools/bcftools.html))
6. _De novo_ assembly
    1. Primer trimming ([`Cutadapt`](https://cutadapt.readthedocs.io/en/stable/guide.html); *amplicon data only*)
    2. Removal of host reads ([`Kraken 2`](http://ccb.jhu.edu/software/kraken2/))
    3. Choice of multiple assembly tools ([`SPAdes`](http://cab.spbu.ru/software/spades/) *||* [`metaSPAdes`](http://cab.spbu.ru/software/meta-spades/) *||* [`Unicycler`](https://github.com/rrwick/Unicycler) *||* [`minia`](https://github.com/GATB/minia))
        * Blast to reference genome ([`blastn`](https://blast.ncbi.nlm.nih.gov/Blast.cgi?PAGE_TYPE=BlastSearch))
        * Contiguate assembly ([`ABACAS`](https://www.sanger.ac.uk/science/tools/pagit))
        * Assembly report ([`PlasmidID`](https://github.com/BU-ISCIII/plasmidID))
        * Assembly assessment report ([`QUAST`](http://quast.sourceforge.net/quast))
        * Call variants relative to reference ([`Minimap2`](https://github.com/lh3/minimap2), [`seqwish`](https://github.com/ekg/seqwish), [`vg`](https://github.com/vgteam/vg), [`Bandage`](https://github.com/rrwick/Bandage))
        * Variant annotation ([`SnpEff`](http://snpeff.sourceforge.net/SnpEff.html), [`SnpSift`](http://snpeff.sourceforge.net/SnpSift.html))
7. Present QC and visualisation for raw read, alignment, assembly and variant calling results ([`MultiQC`](http://multiqc.info/))"]])

(def slide-nf-core-tools-create
  [:section
   [:section
    [:h3 "nf-core tools " [:em "create"]]
    [:small
     [:blockquote "Uses the nf-core template to make a skeleton Nextflow pipeline with all required files, boilerplate code and best-practices."]]
    [:small
     [:ul
      [:li "Highly recommended tool for creating a new production ready workflow"]
      [:li "Helps you use community developed best practices"]]]
    (img-stretch "nf-core-create.svg")]])

(def slide-bactopia
  [:section
   [:h5 [:i.fas.fa-bacteria style-green] "Bactopia: a Flexible Pipeline for Complete Analysis of Bacterial Genomes"]
   [:small [:small "Robert A. Petit III, Timothy D. Read. mSystems Aug 2020, 5 (4) e00190-20. https://doi.org/10.1128/mSystems.00190-20"]]
   (img-stretch "bactopia-workflow.png")
   ])

(def slide-dev-tips
  [:section
   [:h3 [:span style-green "Nextflow"] " | Dev Tips"]
   [:div.row
    [:small [:ul [:li "Use DSL 2 (" [:code "nextflow.enable.dsl=2"] ")"]]]]
   [:div.row
    [:small [:ul [:li "When developing and manually testing a workflow use '" [:code "-resume"] "' to only run things that have changed (results caching)"]]]
    [:pre {:style "font-size:0.5em"}
     [:code.bash "$ nextflow run main.nf -resume ..."]]]
   [:div.row
    [:small
     [:ul
      [:li "Use the 'view' Channel operator to show what's in a channel (print statement debugging)"]]]
    [:pre {:style "font-size:0.5em"}
     [:code.groovy "reads | SPADES | view"]]]
   [:div.row
    [:small
     [:ul
      [:li "Use the 'conda' Process directive to install dependencies for the Process into its own Conda env"]]]
    [:pre {:style "font-size:0.5em"}
     [:code.groovy
      "process SPADES {
  conda \"bioconda::spades=3.14.1\"
  ...
}"]]]
   [:div.row
    [:small
     [:ul
      [:li "Use Nextflow or Groovy syntax highlighting for your editor or IDE"]]]]])

(def slide-workflows-opinions
  [:section
   [:section data-auto-animate
    [:h4 "My experiences with workflow managers"]
    [:div.row {:style "font-size:0.75em;"}
     [:div.col-6
      [:p "Galaxy"]
      [:ul {:style "font-size:0.75em;"}
       [:li "GUI for analyses is great for non-experts"]
       [:li "Tool specification is verbose but thorough"]
       [:li "GUI-based workflow creation is very clunky"]
       [:li "Complex workflows are difficult to create and maintain"]
       [:li "Heavyweight system for executing workflows (need web server, DB, etc)"]]]
     ]]
   [:section data-auto-animate
    [:h4 "My experiences with workflow managers"]
    [:div.row {:style "font-size:0.75em;"}
     [:div.col-6
      [:p "Galaxy"]
      [:ul {:style "font-size:0.75em;"}
       [:li "GUI for analyses is great for non-experts"]
       [:li "Tool specification is verbose but thorough"]
       [:li "GUI-based workflow creation is very clunky"]
       [:li "Complex workflows are difficult to create and maintain"]
       [:li "Heavyweight system for executing workflows (need web server, DB, etc)"]]]
     [:div.col-6
      [:p "Snakemake"]
      [:ul {:style "font-size:0.75em;"}
       [:li "Command-line based"]
       [:li "Productive once \"wildcards\" made sense"]
       [:li "Rapid development (results caching)"]
       [:li "Python integration is very nice"]
       [:li "Difficult to think in terms of output targets and the execution graph"]
       [:li "Not tolerant of errors (can't ignore them)"]
       [:li "Can be slow for large analyses or dynamic analyses (needs to recompute execution graph)"]]]
     ]]
   [:section data-auto-animate
    [:h4 "My experiences with workflow managers"]
    [:div.row {:style "font-size:0.75em;"}
     [:div.col-6
      [:p "Snakemake"]
      [:ul {:style "font-size:0.75em;"}
       [:li "Command-line based"]
       [:li "Productive once \"wildcards\" made sense"]
       [:li "Rapid development (results caching)"]
       [:li "Python integration is very nice"]
       [:li "Difficult to think in terms of output targets and the execution graph"]
       [:li "Not tolerant of errors (can't ignore them)"]
       [:li "Can be slow for large analyses or dynamic analyses (needs to recompute execution graph)"]]]
     [:div.col-6
      [:p "Nextflow"]
      [:ul {:style "font-size:0.75em;"}
       [:li "Command-line based"]
       [:li "Productive once work dir made sense"]
       [:li "Rapid development (results caching)"]
       [:li "Groovy integration is nice (may need to learn some Groovy)"]
       [:li "Easier to think in terms of data flow between processes via channels"]
       [:li "Ignore errors if it makes sense!"]
       [:li "Channel operators provide extreme flexibility (can be overwhelming)"]
       [:li "Very fast even for large complicated analyses (goes with the flow)"]]]
     ]]])

(def slide-nextflow-resources
  [:section
   [:h3 (img "nextflow_logo.png") " Resources"]
   [:small
    [:ul
     [:li [:a {:href "https://www.nextflow.io/" :target "_blank"}
           [:span style-green "Website"] " (https://www.nextflow.io/)"]]
     [:li [:a {:href "https://www.nextflow.io/docs/latest/index.html" :target "_blank"}
           [:span style-green "Docs"] " (https://www.nextflow.io/docs/latest/index.html)"]]
     [:li [:a {:href "https://github.com/nextflow-io/nextflow" :target "_blank"}
           [:span style-green "Github"] " (https://github.com/nextflow-io/nextflow)"]]
     [:li [:a {:href "https://groups.google.com/forum/#!forum/nextflow" :target "_blank"}
           [:span style-green "Discussion Forum"] " (https://groups.google.com/forum/#!forum/nextflow)"]]
     [:li [:a {:href "https://nf-co.re/" :target "_blank"}
           [:span style-green "nf-core"] " (https://nf-co.re/)"]]]]
   (img-stretch "nextflow-install-run-hello.svg")])

(defn all
  "Add here all slides you want to see in your presentation."
  []
  [title-slide
   slide-what-is-nextflow
   slide-bash-make-workflow
   slide-nextflow-overview
   slide-nextflow-overview-rapid-dev
   slide-nextflow-overview-concurrency
   slide-nextflow-overview-scalability
   slide-nextflow-overview-reproducibility
   slide-nextflow-paper-figure-1
   slide-easy-to-install
   slide-run-hello-1
   slide-run-hello-2
   slide-run-hello-3
   slide-nextflow-concepts
   slide-example
   slide-example-code
   slide-work-dir
   slide-work-dir-breakdown
   slide-work-dir-example
   slide-config
   slide-dsl2
   slide-nf-core
   slide-nf-core-pipelines
   slide-nf-core-viralrecon
   slide-bactopia
   slide-nf-core-tools-create
   slide-dev-tips
   slide-tower-nf
   slide-tower-1
   slide-compare-workflow-mgmt-systems
   slide-workflows-opinions
   slide-nextflow-resources])