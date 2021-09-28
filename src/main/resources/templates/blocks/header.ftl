<#macro header>
    <div class="container">
        <header class="pt-2 mb-4 border-bottom border-dark container">
            <div class="row">
                <div class="nav nav-pills col">
                    <a href="/" class="nav-link text-dark underline" id="main">Главная</a>
                    <a href="/operations" class="nav-link  text-dark underline" id="operations-link">Операции</a>
                    <a href="/report/revenue" class="nav-link  text-dark underline" id="rev-report">Отчет по доходам</a>
                    <a href="/report/expense" class="nav-link text-dark underline" id="exp-report">Отчет по расходам</a>
                </div>
                <div class="nav nav-pills justify-content-end col">
                    <a class="nav-link bg-light text-dark ">Я вас категорически приветствую!</a>
                    <a class="nav-link text-dark underline">
                        <form th:action="" method="post">
                            <input type="submit" class="nav-link  text-dark m-0 p-0" value="Выйти"/>
                        </form>
                    </a>
                </div>
            </div>
        </header>
    </div>
</#macro>