package com.taktelon.classspanish;

public class VerbFormProvider {
    public VerbForm getVerbForm(String verb) {
        String verbFormString = getVerbFormString(verb);
        return convertVerbForm(verb, verbFormString);
    }

    private String getVerbFormString(String verb) {
        String verbFormString = null;
        if ("llamar".equals(verb)) {
            verbFormString = "llamo,llamas,llama,llamamos,llaman";
        } else if ("comer".equals(verb)) {
            verbFormString = "como,comes,come,comemos,comen";
        } else if ("vivir".equals(verb)) {
            verbFormString = "vivo,vivis,vive,vivimos,viven";
        }
        return verbFormString;
    }

    private VerbForm convertVerbForm(String verb, String verbFormString) {
        VerbForm verbForm = null;
        if (verbFormString != null) {
            String[] forms = verbFormString.split(",");
            if (forms.length == 5) {
                verbForm = new VerbForm(verb, forms[0], forms[1], forms[2], forms[3], forms[4]);
            }
        }
        return verbForm;
    }

    public class VerbForm {
        private String verb;
        private String formYo;
        private String formVos;
        private String formEl;
        private String formNosotros;
        private String formUstedes;

        public VerbForm(String verb, String formYo, String formVos, String formEl, String formNosotros, String formUstedes) {
            this.verb = verb;
            this.formYo = formYo;
            this.formVos = formVos;
            this.formEl = formEl;
            this.formNosotros = formNosotros;
            this.formUstedes = formUstedes;
        }

        public String getVerb() {
            return verb;
        }

        public String getFormYo() {
            return formYo;
        }

        public String getFormVos() {
            return formVos;
        }

        public String getFormEl() {
            return formEl;
        }

        public String getFormNosotros() {
            return formNosotros;
        }

        public String getFormUstedes() {
            return formUstedes;
        }
    }
}
