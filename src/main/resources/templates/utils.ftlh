<#assign altImage = "https://cdn1.flamp.ru/d9a5cb053d4534fcfcf142e966d896b5.jpg">
<#function getImage img>
    <#if img?has_content && img??>
        <#return img>
    <#else>
        <#return altImage>
    </#if>
</#function>

<#function getDate date format>
    ${date!""}
    <#if date == "">
        <#return date>
    </#if>
    <#if date?has_content && date??>
        <#return date.format(format)>
    <#else>
        <#return "">
    </#if>
</#function>
